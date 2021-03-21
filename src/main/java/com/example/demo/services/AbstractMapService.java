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

    public BaseEntity saveOrUpdate(BaseEntity domainObject) {
        if (domainObject != null){

            if (domainObject.getId() == null){
                domainObject.setId(getNextKey());
            }
            domainMap.put(domainObject.getId(), domainObject);

            return domainObject;
        } else {
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
