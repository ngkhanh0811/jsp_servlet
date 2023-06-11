package com.example.reflection.jpa.implement;/*Welcome to my show !

@author: NgKhanh
Date: 6/2/2023
Time: 7:00 PM

ProjectName: reflection*/

import com.example.reflection.annotation.Column;
import com.example.reflection.annotation.Entity;
import com.example.reflection.annotation.Id;
import com.example.reflection.config.DBConnection;
import com.example.reflection.constant.SqlStatementEnum;
import com.example.reflection.jpa.JpaExecuter;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class JpaExecuterImpl<T> implements JpaExecuter<T> {
    private Class<T> clazz;
    private String className;
    private String tableName;

    public JpaExecuterImpl(Class<T> clazz){
        this.clazz = clazz;
        this.className = clazz.getSimpleName();
        this.tableName = (clazz.getAnnotation(Entity.class) != null) ? clazz.getAnnotation(Entity.class).tablename() :
                this.className.toLowerCase();
    }
    @Override
    public List<T> findall(){
        Connection conn = null;
        try {
            conn = DBConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(conn == null) {
            // todo: log
            System.err.println("Connection is null" + conn);
        } else {
            System.err.println(conn);
        }

        StringBuilder statement = new StringBuilder().append(SqlStatementEnum.SELECT_ASTERISK.value)
                .append(SqlStatementEnum.SPACE.value).append(SqlStatementEnum.FROM).append(SqlStatementEnum.SPACE.value).append(tableName);

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(statement.toString());

            ResultSet rs = preparedStatement.executeQuery();
//            String title = rs.getString("title");
            return entityParser(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<T> entityParser(ResultSet rs){
        List<T> entitys = new ArrayList<>();
        try {
            while(rs.next()){
                T entity = clazz.getDeclaredConstructor().newInstance();
                for(Field f : entity.getClass().getDeclaredFields()){
                    String columnName = f.getName();
                    if (f.isAnnotationPresent(Column.class) && !StringUtils.isEmpty(f.getAnnotation(Column.class).name())){
                        Column columnInfo = f.getAnnotation(Column.class);
                        columnName = columnInfo.name();
                        f.setAccessible(true);
                        switch (columnInfo.dataType()){
                            case INTEGER: f.set(entity, rs.getInt(columnName));
                            break;
                            case TEXT: f.set(entity, rs.getString(columnName));
                            break;
                            case BIG_INTEGER: f.set(entity, rs.getInt(columnName));
                            break;
                            case SMALL_INTEGER: f.set(entity, rs.getInt(columnName));
                            break;
                            case DATE: f.set(entity, rs.getDate(columnName));
                            break;
                            case FLOAT: f.set(entity, rs.getFloat(columnName));
                            break;
                            case DOUBLE: f.set(entity, rs.getInt(columnName));
                            break;
                            // todo : Làm tiếp tục với các kiểu dữ liệu còn lại
                            // fixme: Fix nốt đê
                        }
                    }
                }
                entitys.add(entity);
            }
        }
        catch (SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e){
            throw new RuntimeException();
        }

        return entitys;
    }

    @Override
    public T getItemById(String id) {
        Connection conn = null;
        try {
            conn = DBConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(conn == null) {
            // todo: log
            System.err.println("Connection is null" + conn);
        } else {
            System.err.println(conn);
        }
        String idColumn = null;
        // get column name of id
        for(Field f : clazz.getDeclaredFields()){
            if (f.isAnnotationPresent(Id.class)){
                // id is existed
//                idColumn = f.getAnnotation(Id.class).name();

                idColumn = (StringUtils.isEmpty(f.getAnnotation(Id.class).name())) ? f.getName() : f.getAnnotation(Id.class).name().trim();
            }
        }
        StringBuilder statement = new StringBuilder().append(SqlStatementEnum.SELECT_ASTERISK.value)
                .append(SqlStatementEnum.SPACE.value).append(SqlStatementEnum.FROM).append(SqlStatementEnum.SPACE.value).append(tableName).append(SqlStatementEnum.SPACE.value).append(SqlStatementEnum.WHERE).append(SqlStatementEnum.SPACE.value).append(idColumn).append(SqlStatementEnum.SPACE.value).append(SqlStatementEnum.EQUAL).append(SqlStatementEnum.QUEST);
    try {
        PreparedStatement preparedStatement = conn.prepareStatement(statement.toString());
        preparedStatement.setString(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        List<T> results = entityParser(rs);
        if (!Object.isNull(results) && results.size() > 0){
            return results.get(0);
        }
    }
     catch (SQLException e) {
        throw new RuntimeException();
    }
        return null;
    }
}
