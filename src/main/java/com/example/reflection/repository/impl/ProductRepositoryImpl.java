package com.example.reflection.repository.impl;/*Welcome to my show !

@author: NgKhanh
Date: 6/2/2023
Time: 7:22 PM

ProjectName: reflection*/

import com.example.reflection.entity.Product;
import com.example.reflection.jpa.implement.JpaExecuterImpl;
import com.example.reflection.repository.ProductRepository;

import java.util.List;

public class ProductRepositoryImpl  extends JpaExecuterImpl<Product>  {
    public ProductRepositoryImpl() {
        super(Product.class);
    }
}