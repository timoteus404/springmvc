package com.example.demo.services;

import com.example.demo.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService{

    private Map<Integer,Customer> customers;

    public CustomerServiceImpl() {
        loadCustomer();
    }
    
    @Override
    public List<Customer> listAllCustomer() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customers.get(id);
    }

    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {
        if (customer != null){
            if (customer.getId() == null){
                customer.setId(getNextKey());
            }
            customers.put(customer.getId(), customer);

            return customer;
        } else {
            throw new RuntimeException("Product Can't be nill");
        }
    }

    @Override
    public void delete(Integer id) {
        customers.remove(id);
    }

    private Integer getNextKey(){
        return Collections.max(customers.keySet()) + 1;
    }

    private void loadCustomer(){
        customers = new HashMap<>();

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("Customer 1");
        customer1.setLastName("Tim");
        customer1.setEmail("tim@gmail.com");
        customer1.setPhoneNumber("0998919536");
        customer1.setAddressLineOne("USA");
        customer1.setAddressLineTwo("America");
        customer1.setCity("New York");
        customer1.setState("NY");
        customer1.setZipCode("01234");


        customers.put(1, customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setFirstName("Customer 2");
        customer2.setLastName("Tom");
        customer2.setEmail("tim1@gmail.com");
        customer2.setPhoneNumber("0998919536");
        customer2.setAddressLineOne("USA");
        customer2.setAddressLineTwo("America");
        customer2.setCity("New York");
        customer2.setState("NY");
        customer2.setZipCode("01234");

        customers.put(2, customer2);

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setFirstName("Customer 3");
        customer3.setLastName("Edd");
        customer3.setEmail("edd@gmail.com");
        customer3.setPhoneNumber("0998919536");
        customer3.setAddressLineOne("USA");
        customer3.setAddressLineTwo("America");
        customer3.setCity("New York");
        customer3.setState("NY");
        customer3.setZipCode("01234");

        customers.put(3, customer3);

        Customer customer4 = new Customer();
        customer4.setId(4);
        customer4.setFirstName("Customer 4");
        customer4.setLastName("Tomy");
        customer4.setEmail("tomy@gmail.com");
        customer4.setPhoneNumber("0998919536");
        customer4.setAddressLineOne("USA");
        customer4.setAddressLineTwo("America");
        customer4.setCity("New York");
        customer4.setState("NY");
        customer4.setZipCode("01234");
        customers.put(4, customer4);

        Customer customer5 = new Customer();
        customer5.setId(5);
        customer5.setFirstName("Customer 5");
        customer5.setLastName("Low");
        customer5.setEmail("low@gmail.com");
        customer5.setPhoneNumber("0998919536");
        customer5.setAddressLineOne("USA");
        customer5.setAddressLineTwo("America");
        customer5.setCity("New York");
        customer5.setState("NY");
        customer5.setZipCode("01234");

        customers.put(5, customer5);
    }
}
