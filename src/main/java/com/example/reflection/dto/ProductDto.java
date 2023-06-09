package com.example.reflection.dto;/*Welcome to my show !

@author: NgKhanh
Date: 6/5/2023
Time: 8:55 PM

ProjectName: reflection*/

import com.example.reflection.annotation.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data

public class ProductDto {
    private long id;
    private String name;
    private String category;
    private int price;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private int status;



    public void setId(long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }


};

