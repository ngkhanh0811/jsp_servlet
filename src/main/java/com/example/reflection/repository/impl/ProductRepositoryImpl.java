package com.example.reflection.repository.impl;/*Welcome to my show !

@author: NgKhanh
Date: 6/2/2023
Time: 7:22 PM

ProjectName: reflection*/

import com.example.reflection.entity.Product;
import com.example.reflection.jpa.implement.JpaExecuterImpl;
import com.example.reflection.repository.ProductRepository;

import java.util.List;

public class ProductRepositoryImpl  extends JpaExecuterImpl<Product> implements ProductRepository  {
    public ProductRepositoryImpl() {
        super(Product.class);
    }

    @Override
    public Object getAll() {
        return findall();
    }
    @Override
    public Product getById(String id){
        return super.getItemById(id); // có nguy cơ gây ra đệ quy
    }
}