package com.futuro.entities;

import com.futuro.domain.product.RequestProduct;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Table(name="product")
@Entity(name="product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer price_in_cents;
    @Version
    private Integer version;
    private String productId;
    private BigDecimal price;

    public Product(RequestProduct requestProduct) {
        this.name = requestProduct.name();
        this.price_in_cents = requestProduct.price_in_cents();
    }
}
