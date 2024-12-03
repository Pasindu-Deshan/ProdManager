package com.telusko.myApp.TestApplication.Controller;

import com.telusko.myApp.TestApplication.Model.Product;
import com.telusko.myApp.TestApplication.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProduct(){
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/products/{prodID}")
    public ResponseEntity<Product> getProductById(@PathVariable int prodID){

        Product product = productService.getProductByID(prodID);

        if (product != null){
            return new ResponseEntity<>(productService.getProductByID(prodID), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*@PostMapping("/products")
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }*/

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
    }

    @DeleteMapping("/products/{prodID}")
    public void deleteProduct(@PathVariable int prodID){
        productService.deleteProduct(prodID);
    }

    @PostMapping("product/")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
        try {
            Product product1 = productService.addProduct(product, imageFile);
            return new ResponseEntity<>(product1, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("product/{productID}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productID){
        Product product = productService.getProductByID(productID);
        byte[] imageFile = product.getImageData();

        return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType())).body(imageFile);
    }
}
