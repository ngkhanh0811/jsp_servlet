package com.example.reflection.service;/*Welcome to my show !

@author: NgKhanh
Date: 6/5/2023
Time: 8:53 PM

ProjectName: reflection*/

import com.example.reflection.dto.ProductDto;
import com.example.reflection.entity.Product;
import java.util.List;

public interface ProductServiceInterface {
    List<Product> getListProduct();
    ProductDto getById(String id);
}
