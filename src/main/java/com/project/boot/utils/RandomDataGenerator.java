package com.project.boot.utils;

import com.project.boot.domain.Product;
import com.project.boot.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static java.time.LocalDateTime.now;

@Service
@RequiredArgsConstructor
public class RandomDataGenerator {

    private final ProductRepository repository;

    private static int getRandomInt(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("MAX must be bigger than MIN");
        }
        if (min == max) {
            return min;
        }
        int diff = max - min;
        int random = ThreadLocalRandom.current().nextInt(diff + 1);
        return random + min;
    }

    private Product getRandomProduct() {
        return Product.builder()
                .productName(getRandomString())
                .price(BigDecimal.valueOf(getRandomPrice()))
                .date(Timestamp.valueOf(now()))
                .build();
    }

    private int getRandomPrice() {
        return getRandomInt(10, 100);
    }

    private String getRandomString() {
        return RandomStringUtils.random(10, true, false);
    }

    public void init(Integer count) {
        Stream.generate(this::getRandomProduct)
                .limit(count)
                .forEach(repository::save);
    }
}
