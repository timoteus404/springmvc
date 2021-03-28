package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Customer extends BaseEntity{

    @Column
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String addressLineOne;
    private String addressLineTwo;
    private String city;
    private String state;
    private String zipCode;

    @Version
    private Integer version;

    @OneToOne
    private User user;

}
