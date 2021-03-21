package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/customers")
    public String listCustomer(Model model){
        model.addAttribute("customers", customerService.listAllCustomer());
        return "customers";
    }

    @RequestMapping("/customers/{id}")
    public String getProduct(@PathVariable Integer id, Model model){

        model.addAttribute("customers", customerService.getCustomerById(id));

        return "customers";
    }

    @RequestMapping("customers/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("customers", customerService.getCustomerById(id));
        return "customerform";
    }

    @RequestMapping("/customers/new")
    public String newProduct(Model model){
        model.addAttribute("customers", new Customer());
        return "customerform";
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public String saveOrUpdateProduct(Customer customer){
        Customer savedCustomer = customerService.saveOrUpdateCustomer(customer);
//        return "redirect:/customers/" + savedCustomer.getId();
        return "redirect:/customers";
    }

    @RequestMapping("/customers/delete/{id}")
    public String delete(@PathVariable Integer id){
        customerService.delete(id);
        return "redirect:/customers";

    }
}
