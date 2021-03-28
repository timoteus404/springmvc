package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "user_account")
public class User extends BaseEntity{
    @Column
    private String username;

    @Transient
    private String password;
    @Column
    private String encryptedPassword;

    @Version
    @Column
    private Integer version;
    @Column
    private Boolean encrypted = true;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Customer customer;

    //can we do this
    public void setCustomer(Customer customer) {
        this.customer = customer;
        customer.setUser(this);
    }

}
