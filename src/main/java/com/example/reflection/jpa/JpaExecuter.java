package com.example.reflection.jpa;/*Welcome to my show !

@author: NgKhanh
Date: 6/2/2023
Time: 6:55 PM

ProjectName: reflection*/

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public interface JpaExecuter<T> {
    List<T> findall();
    List<T> entityParser(ResultSet rs);
    T getItemById(String id);
}
