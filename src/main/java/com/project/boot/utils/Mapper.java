package com.project.boot.utils;

import com.project.boot.domain.Product;
import com.project.boot.dto.CreateProductDTO;
import com.project.boot.dto.ProductDTO;
import com.project.boot.dto.UpdateProductDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

import static java.time.LocalDateTime.now;

@Component
@RequiredArgsConstructor
public class Mapper {

    private final ModelMapper mapper;

    public Product map(CreateProductDTO dto) {
        var entity = mapper.map(dto, Product.class);
        entity.setDate(Timestamp.valueOf(now()));
        return entity;
    }

    public ProductDTO map(Product dao) {
        return mapper.map(dao, ProductDTO.class);
    }

    public Product map(Product dao, UpdateProductDTO.ProductDTO dto) {
        mapper.map(dto, dao);
        return dao;
    }
}
