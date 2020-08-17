package com.project.boot.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

@Data
@Builder
@Entity(name = "products")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_ids_gen")
    @SequenceGenerator(name = "products_ids_gen", sequenceName = "user_settings_id_seq", allocationSize = 1)
    private BigInteger id;
    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private Timestamp date;

}
