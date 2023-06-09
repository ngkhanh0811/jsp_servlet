package com.example.reflection.mapper;/*Welcome to my show !

@author: NgKhanh
Date: 6/5/2023
Time: 9:00 PM

ProjectName: reflection*/

import com.example.reflection.dto.ProductDto;
import com.example.reflection.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    Product dtoToEntity(ProductDto productDto);
    ProductDto entityToDto(Product product);
}
