package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Product extends BaseEntity{


    private String description;
    private BigDecimal price;
    private String imageUrl;

    @Version
    private Integer version;

}
