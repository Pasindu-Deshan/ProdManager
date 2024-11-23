package com.telusko.myApp.TestApplication.Service;

import com.telusko.myApp.TestApplication.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = new ArrayList<> (Arrays.asList(
            new Product(001, "Iphone 14", 200000),
            new Product(002, "Iphone 15", 240000),
            new Product(003, "Iphone 16", 400000),
            new Product(004, "Galaxy S24", 640000)
    ));

    public List<Product> getProducts(){
        return products;
    }

    public Product getProductByID(int prodID) {
        return products.stream()
                .filter(p -> p.getProductID() == prodID)
                .findFirst()
                .orElse(new Product(5, "No Product", 0));
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(Product product) {
        int index = 0;
        for (int i = 0; i < products.size(); i++){
            if (products.get(i).getProductID() == product.getProductID()){
                index = i;
            }
        }
        products.set(index, product);
    }

    public void deleteProduct(int productID) {
        int index = 0;
        for (int i = 0; i < products.size(); i++){
            if (products.get(i).getProductID() == productID){
                index = i;
            }
        }
        products.remove(index);
    }
}
