package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Customer {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String addressLineOne;
    private String addressLineTwo;
    private String city;
    private String state;
    private String zipCode;

}
