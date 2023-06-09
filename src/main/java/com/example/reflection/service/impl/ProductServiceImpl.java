package com.example.reflection.service.impl;/*Welcome to my show !

@author: NgKhanh
Date: 6/5/2023
Time: 9:06 PM

ProjectName: reflection*/

import com.example.reflection.dto.ProductDto;
import com.example.reflection.entity.Product;
import com.example.reflection.impl.ProductService;
import com.example.reflection.mapper.ProductMapper;
import com.example.reflection.mapper.impl.ProductMapperImpl;
import com.example.reflection.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {
    ProductRepository productRepo;

    ProductMapperImpl productMap = new ProductMapperImpl();

    public static void main(String[] args) {
        List<String> students = Arrays.asList("A", "B", "C");
        List<String> studentCode = students.stream().map(
                item -> item+ "_" + "id"
        ).collect(Collectors.toList());

        System.err.println(studentCode);

        students.forEach(System.err::println);
    }


    @Override
    public List<ProductDto> getListProduct(){

        productRepo.findall().stream().map(p -> productMap.entityToDto(p)).collect(Collectors.toList());
        return productRepo.findall().stream().map(productMap :: entityToDto)
                .collect(Collectors.toList());
    }
}
