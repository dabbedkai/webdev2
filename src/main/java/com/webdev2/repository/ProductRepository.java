package com.webdev2.repository;

import com.webdev2.model.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository {
    private final Map<Long, Product> store = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public ProductRepository() {
        save(new Product(null, "Mechanical Keyboard", "Electronics", new BigDecimal("89.99"), 12));
        save(new Product(null, "Ergonomic Chair", "Furniture", new BigDecimal("249.50"), 5));
    }

    public List<Product> findAll() {
        return store.values().stream().toList();
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(idCounter.getAndIncrement());
        }
        store.put(product.getId(), product);
        return product;
    }
}