package com.telusko.myApp.TestApplication.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Product {

    @Id
    private int productID;
    private String productName;
    private int price;

    public Product(int productID, String productName, int price) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
    }

    public Product() {

    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}
