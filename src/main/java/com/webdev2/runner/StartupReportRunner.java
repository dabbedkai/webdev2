package com.webdev2.runner;

import com.webdev2.model.Product;
import com.webdev2.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StartupReportRunner implements CommandLineRunner {

    private final ProductService productService;

    public StartupReportRunner(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run(String... args) {
        double threshold = 5000.0;
        List<Product> expensiveProducts = productService.getProductsAbovePrice(threshold);

        System.out.println("================================");
        System.out.println("       PRODUCT REPORT");
        System.out.println("================================");
        System.out.println("Shop: " + productService.getShopName());
        System.out.println("Currency: " + productService.getShopCurrency());
        System.out.println();
        System.out.printf("Products above %s %.0f:%n%n", productService.getShopCurrency(), threshold);

        for (Product product : expensiveProducts) {
            System.out.printf("%s - %s %.0f%n", 
                    product.getName(), 
                    productService.getShopCurrency(), 
                    product.getPrice());
        }
        System.out.println("================================");
    }
}