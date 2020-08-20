package com.project.boot.service;

import com.project.boot.domain.Product;
import com.project.boot.dto.CreateProductDTO;
import com.project.boot.dto.ProductDTO;
import com.project.boot.dto.UpdateProductDTO;
import com.project.boot.repository.ProductRepository;
import com.project.boot.utils.Mapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final Mapper mapper;

    public ProductDTO findProductById(BigInteger id) {
        return mapper.map(repository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException(String.format("Product with id %s not found!", id))));
    }

    public List<ProductDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::map)
                .collect(toList());
    }

    public Product createProduct(CreateProductDTO dto) {
        return repository.save(mapper.map(dto));
    }

    public List<Product> update(UpdateProductDTO request) {
        if (request.getProducts().isEmpty()) {
            return Collections.emptyList();
        }
        List<Product> processedProducts = request.getProducts().stream()
                .map(dto -> {
                    Product storedProduct = repository.findById(dto.getId())
                            .orElseThrow(() -> new EntityNotFoundException(
                                    String.format("Product with id: %s not found!", dto.getId())));
                    return mapper.map(storedProduct, dto);
                }).collect(toList());
        return repository.saveAll(processedProducts);
    }

    public void deleteById(BigInteger id) {
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
