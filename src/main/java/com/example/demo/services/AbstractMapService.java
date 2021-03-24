package com.example.demo.services;

import com.example.demo.entity.BaseEntity;

import java.util.*;

public abstract class AbstractMapService{

    protected Map<Integer, BaseEntity> domainMap;

    public AbstractMapService() {
        domainMap = new HashMap<>();
        loadDomainObjects();
    }

    public List<BaseEntity> listAll() {
        return new ArrayList<BaseEntity>(domainMap.values());
    }

    public BaseEntity getById(Integer id) {
        return domainMap.get(id);
    }

    ///possibly causing SQLTransientConnectionException
    public BaseEntity saveOrUpdate(BaseEntity domainObject) {
        System.out.println("saveOrUpdate is running");
        if (domainObject != null){
            System.out.println("saveOrUpdate is running");
            if (domainObject.getId() == null){
                domainObject.setId(getNextKey());
            }
            System.out.println("saveOrUpdate is running");
            domainMap.put(domainObject.getId(), domainObject);
            System.out.println("saveOrUpdate is running");
            return domainObject;
        } else {
            System.out.println("saveOrUpdate is running");
            throw new RuntimeException("Object Can't be null");
        }
    }

    public void delete(Integer id) {
        domainMap.remove(id);
    }

    private Integer getNextKey(){
        return Collections.max(domainMap.keySet()) + 1;
    }

    protected abstract void loadDomainObjects();
}
