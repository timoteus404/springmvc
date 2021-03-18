package com.example.demo.services;

import com.example.demo.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveOrUpdateProduct(Product product);

    void delete(Integer id);

}
