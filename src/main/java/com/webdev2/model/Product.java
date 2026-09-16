package com.webdev2.model;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class Product {
    private Long id;

    @NotBlank(message = "Product name cannot be blank.")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters.")
    private String name;

    @NotBlank(message = "Category is required.")
    private String category;

    @NotNull(message = "Price is required.")
    @DecimalMin(value = "0.01", message = "Price must be greater than zero.")
    private BigDecimal price;

    @NotNull(message = "Stock level is required.")
    @Min(value = 0, message = "Stock cannot be negative.")
    private Integer stock;

    public Product() {}

    public Product(Long id, String name, String category, BigDecimal price, Integer stock) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
}