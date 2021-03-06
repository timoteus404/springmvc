package com.example.demo.services.dao;

import com.example.demo.entity.Customer;
import com.example.demo.services.CustomerService;
import com.example.demo.services.security.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
@Profile("jpadao")
public class CustomerServiceDaoImpl extends AbstractJpaDaoService implements CustomerService {

    private EncryptionService encryptionService;

    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }
    @Override
    public List<Customer> listAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Customer", Customer.class).getResultList();
    }

    @Override
    public Customer getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Customer.class, id);
    }

    @Override
    public Customer saveOrUpdate(Customer entity) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        if (entity.getUser() != null && entity.getUser().getPassword() != null) {
            entity.getUser().setEncryptedPassword(
                    encryptionService.encryptString(entity.getUser().getPassword()));
        }

        Customer savedCustomer = em.merge(entity);
        em.getTransaction().commit();

        return savedCustomer;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Customer.class, id));
        em.getTransaction().commit();
//        em.getTransaction().rollback();
    }
}
