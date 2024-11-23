package com.telusko.myApp.TestApplication.Service;

import com.telusko.myApp.TestApplication.Model.Product;
import com.telusko.myApp.TestApplication.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    List<Product> products = new ArrayList<> (Arrays.asList(
            new Product(001, "Iphone 14", 200000),
            new Product(002, "Iphone 15", 240000),
            new Product(003, "Iphone 16", 400000),
            new Product(004, "Galaxy S24", 640000)
    ));

    public List<Product> getProducts(){
        return productRepo.findAll();
    }

    public Product getProductByID(int prodID) {
        return productRepo.findById(prodID).orElse(new Product());
    }

    public void addProduct(Product product) {
        productRepo.save(product);
    }

    public void updateProduct(Product product) {
        productRepo.save(product);
    }

    public void deleteProduct(int productID) {
        productRepo.deleteById(productID);
    }
}
