package com.example.demo.services.mapservices;

import com.example.demo.entity.BaseEntity;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.services.UserService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("map")
public class UserServiceImpl extends AbstractMapService implements UserService {

    @Override
    public List<BaseEntity> listAll() {
        return super.listAll();
    }

    @Override
    public User getById(Integer id) {
        return (User) super.getById(id);
    }

    @Override
    public User saveOrUpdate(User entity) {
        return (User) super.saveOrUpdate(entity);
    }

    @Override
    public void delete(Integer id){
        super.delete(id);
    }

    @Override
    protected void loadDomainObjects() {

    }
}
