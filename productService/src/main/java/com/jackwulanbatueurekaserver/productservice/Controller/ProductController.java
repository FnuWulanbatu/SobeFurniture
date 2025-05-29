package com.jackwulanbatueurekaserver.productservice.Controller;


import com.jackwulanbatueurekaserver.productservice.Service.ProductService;
import com.jackwulanbatueurekaserver.productservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;


    @PostMapping
    public ResponseEntity create(@RequestBody Product product) {
        return ResponseEntity.ok("Product has successfully added. " + productService.createProduct(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long Id){
        return ResponseEntity.ok(productService.getProductById(Id));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(productService.getAllProduct());
    }

    public ResponseEntity<List<Product>> search (@RequestParam(required = false)String name,@RequestParam(required = false)String category ){
        if(name != null){
            return ResponseEntity.ok(productService.searchByName(name));
        }
        if(category != null){
            return ResponseEntity.ok(productService.searchByCategory(category));
        }
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<Void> delete(@PathVariable Long Id){
        productService.deleteProduct(Id);
        return ResponseEntity.ok().build();
    }



}
