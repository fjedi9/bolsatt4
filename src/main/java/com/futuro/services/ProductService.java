package com.futuro.services;

import com.futuro.entities.Product;

public interface ProductService{
    Iterable<Product> listAllProducts();
    Product getProductById(Integer Id);
    Product saveProduct(Product product);
    void deleteProduct(Integer id);
}
