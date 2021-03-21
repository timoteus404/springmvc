package com.example.demo.services;

import com.example.demo.entity.Customer;

import java.util.List;

public interface CRUDService<T> {

    List<?> listAll();

    T getById(Integer id);

    T saveOrUpdate(T entity);

    void delete(Integer id);
}