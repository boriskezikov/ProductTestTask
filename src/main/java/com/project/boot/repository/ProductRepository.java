package com.project.boot.repository;

import com.project.boot.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, BigInteger> {

    List<Product> findAllByDateBetween(Timestamp from, Timestamp to);
}
