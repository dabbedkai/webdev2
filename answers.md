# Lab 4: Server-Rendered CRUD Interface

## Overview
* **Repository Branch:** week4
* **Application Port:** 8082

## Task Implementation Summary

### Task 1 - Product List Template
* **File:** `src/main/resources/templates/products.html`
* **Implementation:** Rendered the product catalog using `th:each`, `th:text`, and an empty list check using `th:if`.
* **Evidence:** `screenshots/products_list.png`

### Task 2 - Product Detail Template
* **File:** `src/main/resources/templates/product-detail.html`
* **Implementation:** Displayed product properties using variable expressions and accessed the nested category name using `${product.category.name}`.
* **Evidence:** `screenshots/product_detail.png`

### Task 3 - Shared Navigation Fragment
* **File:** `src/main/resources/templates/fragments/navbar.html`
* **Implementation:** Extracted navigation markup into a shared Thymeleaf fragment (`th:fragment="navbar"`) and embedded it into both `products.html` and `product-detail.html` using `th:replace`.

### Task 4 - Create Form
* **File:** `src/main/resources/templates/product-form.html`
* **Implementation:** Created a form bound to the backing `Product` model using `th:object` and `th:field`. Redirected back to `/products` upon successful submission.
* **Evidence:** `screenshots/form_submit.png`

### Task 5 -s Binding Errors on Create Form
* **Files:** `ProductController.java`, `product-form.html`
* **Implementation:** Passed `BindingResult` into `@PostMapping` to detect type conversion failures (e.g., non-numeric price) and displayed error messages on the form using `th:errors`.
* **Evidence:** `screenshots/binding_error.png`