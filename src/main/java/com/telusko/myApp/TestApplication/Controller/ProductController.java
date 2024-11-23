package com.telusko.myApp.TestApplication.Controller;

import com.telusko.myApp.TestApplication.Model.Product;
import com.telusko.myApp.TestApplication.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getProduct(){
        return productService.getProducts();
    }

    @GetMapping("/products/{prodID}")
    public Product getProductById(@PathVariable int prodID){
        return productService.getProductByID(prodID);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
    }

    @DeleteMapping("/products/{prodID}")
    public void deleteProduct(@PathVariable int prodID){
        productService.deleteProduct(prodID);
    }
}
