package com.example.demo.services.dao;

import com.example.demo.entity.User;
import com.example.demo.services.UserService;
import com.example.demo.services.security.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Profile("jpadao")
public class UserDaoImpl extends AbstractJpaDaoService implements UserService {

    private EncryptionService encryptionService;

    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @Override
    public List<User> listAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("From User", User.class).getResultList();
    }

    @Override
    public User getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(User.class, id);
    }

    @Override
    public User saveOrUpdate(User entity) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        if(entity.getPassword() != null){
            entity.setEncryptedPassword(encryptionService.encryptString(entity.getPassword()));
        }

        User saved = em.merge(entity);
        em.getTransaction().commit();

        return saved;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(User.class, id));
        em.getTransaction().commit();
    }
}
