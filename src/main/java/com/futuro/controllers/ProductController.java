package com.futuro.controllers;


import com.futuro.entities.Product;
import com.futuro.domain.product.ProductRepository;
import com.futuro.domain.product.RequestProduct;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository repository;
//Lista os produtos
    @GetMapping
    public ResponseEntity getAllProduct() {
        var allProducts = repository.findAll();
        return ResponseEntity.ok(allProducts);

    }
//mostra o produto
    @PostMapping
    public ResponseEntity registerProduct(@RequestBody @Valid RequestProduct data) {
        Product newProduct = new Product(data);
        repository.save(newProduct);
        return ResponseEntity.ok().build();
    }
//altera o produto
    @PutMapping
    @Transactional
    public String updateProduct(@RequestBody @Valid RequestProduct data){
        Optional<Product> optionalProduct = repository.findById(data.id());
        if (optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.setName(data.name());
            product.setPrice_in_cents(data.price_in_cents());
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    @DeleteMapping
            public String delete(@PathVariable Integer id){
                optionalProduct.deleteProduct(id);
                return "redirect:/products";
        }

    }

}