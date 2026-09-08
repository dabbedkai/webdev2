package com.webdev2.service;

import com.webdev2.config.ShopProperties;
import com.webdev2.model.Product;
import com.webdev2.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ShopProperties shopProperties;

    // Constructor Injection (Task 3 & 4)
    public ProductService(ProductRepository productRepository, ShopProperties shopProperties) {
        this.productRepository = productRepository;
        this.shopProperties = shopProperties;
    }

    public List<Product> getProductsAbovePrice(double priceThreshold) {
        return productRepository.findAll().stream()
                .filter(product -> product.getPrice() > priceThreshold)
                .collect(Collectors.toList());
    }

    public String getShopName() {
        return shopProperties.getName();
    }

    public String getShopCurrency() {
        return shopProperties.getCurrency();
    }
}