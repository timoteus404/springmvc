package com.example.demo.services;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Product;

import java.util.List;

public interface CustomerService {

    List<Customer> listAllCustomer();

    Customer getCustomerById(Integer id);

    Customer saveOrUpdateCustomer(Customer customer);

    void delete(Integer id);
}
