package com.jackwulanbatueurekaserver.productservice.Service;

import com.jackwulanbatueurekaserver.productservice.model.Product;
import com.jackwulanbatueurekaserver.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            return optionalProduct.get();
        }else{
            throw new RuntimeException("Product id doesn't exist");
        }
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> searchByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> searchByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public void deleteProduct(Long Id) {
        productRepository.deleteById(Id);
        System.out.println(Id + " has been deleted.");
    }
}
