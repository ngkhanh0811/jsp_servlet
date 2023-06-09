package com.example.reflection.mapper;

import com.example.reflection.dto.ProductDto;
import com.example.reflection.entity.Product;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-09T20:48:17+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product dtoToEntity(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDto.getId() );
        product.setName( productDto.getName() );
        product.setCategory( productDto.getCategory() );
        product.setPrice( productDto.getPrice() );
        product.setStatus( productDto.getStatus() );

        return product;
    }

    @Override
    public ProductDto entityToDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setStatus( product.getStatus() );
        productDto.setId( product.getId() );
        productDto.setName( product.getName() );
        productDto.setCategory( product.getCategory() );
        productDto.setPrice( product.getPrice() );

        return productDto;
    }
}
