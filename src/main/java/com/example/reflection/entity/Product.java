package com.example.reflection.entity;/*Welcome to my show !

@author: NgKhanh
Date: 6/2/2023
Time: 6:49 PM

ProjectName: reflection*/

import com.example.reflection.annotation.Column;
import com.example.reflection.annotation.Entity;
import com.example.reflection.annotation.Id;
import com.example.reflection.constant.SqlDataType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Data
@Getter
@Setter
@Entity(tablename = "book")
public class Product {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStatus(int status) { this.status = status; }

    public int getStatus() { return status; }

    @Id(name = "bookID")
    private long id;
    @Column(name = "title", dataType = SqlDataType.TEXT)
    private String name;
    @Column(name = "category", dataType = SqlDataType.TEXT)
    private String category;
    @Column(name = "price", dataType= SqlDataType.INTEGER)
    private int price;
    @Column(name = "status", dataType = SqlDataType.INTEGER)
    private int status;
}


