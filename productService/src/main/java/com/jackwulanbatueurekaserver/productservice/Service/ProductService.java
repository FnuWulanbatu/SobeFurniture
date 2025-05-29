package com.jackwulanbatueurekaserver.productservice.Service;

import com.jackwulanbatueurekaserver.productservice.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product getProductById(Long Id);
    List<Product> getAllProduct();
    List<Product> searchByName(String name);
    List<Product> searchByCategory(String category);
    void deleteProduct(Long Id);
}
