package com.project.boot.controller;

import com.project.boot.domain.Product;
import com.project.boot.dto.CreateProductDTO;
import com.project.boot.dto.ProductDTO;
import com.project.boot.dto.UpdateProductDTO;
import com.project.boot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

import static com.project.boot.utils.Constants.PRODUCT_CONTROLLER_URL;

@RestController
@RequestMapping(PRODUCT_CONTROLLER_URL)
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping("/{id}")
    public ProductDTO findProductById(@PathVariable BigInteger id) {
        return service.findProductById(id);
    }

    @GetMapping
    public List<ProductDTO> findAll() {
        return service.findAll();
    }

    @PostMapping
    @RequestBody 
    public Product createProduct(@Validated CreateProductDTO productDTO) {
        return service.createProduct(productDTO);
    }

    @PutMapping
    @RequestBody 
    public List<Product> update(@Validated UpdateProductDTO productDTO) {
        return service.update(productDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable BigInteger id) {
        service.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll() {
        service.deleteAll();
    }
}
