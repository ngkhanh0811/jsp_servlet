package com.example.reflection.repository;/*Welcome to my show !

@author: NgKhanh
Date: 6/2/2023
Time: 7:22 PM

ProjectName: reflection*/

import com.example.reflection.entity.Product;

import java.util.List;

public interface ProductRepository {
    Object getAll();

    List<Product> findall();

    Product getById(String id);
}
