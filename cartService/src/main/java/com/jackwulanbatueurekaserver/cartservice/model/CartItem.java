package com.jackwulanbatueurekaserver.cartservice.model;


import jakarta.persistence.*;

import java.awt.geom.GeneralPath;
import java.time.LocalDateTime;

@Entity
@Table(name = "cart_items")
public class CartItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "user_Id", nullable = false)
    private Long userId;
    @Column(name = "product_Id", nullable = false)
    private Long productId;
    @Column(nullable = false)
    private int quantity;
    @Column(name = "added_time")
    private LocalDateTime addedTime = LocalDateTime.now();

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(LocalDateTime addedTime) {
        this.addedTime = addedTime;
    }
}
