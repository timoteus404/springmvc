package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Getter
@Setter
@Entity
public class CartDetail extends BaseEntity{

    @Version
    private Integer version;

    @ManyToOne
    private Cart cart;

    @OneToOne
    private Product product;
}
