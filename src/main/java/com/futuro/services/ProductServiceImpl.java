package com.futuro.services;


import com.futuro.domain.product.ProductRepository;
import com.futuro.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> listAllProducts(){
        return productRepository.findAll();
    }
    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
