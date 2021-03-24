package com.example.demo.services.dao;

import com.example.demo.entity.Product;
import com.example.demo.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
@Profile("jpadao")
public class ProductServiceDaoImpl implements ProductService {

    private EntityManagerFactory emf;

    //JPA standard. Tells to inject emf.
    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Product> listAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("From Product", Product.class).getResultList();
    }

    @Override
    public Product getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Product.class, id);
    }

    /**
     * This method is saving the data as a new object if that object doesn't exist in the database.
     * If the object already in the database, it will update (merge) the objects.
     * @param product entity
     * @return result that is updated or newly created
     */
    @Override
    public Product saveOrUpdate(Product product) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Product result = em.merge(product);
        em.getTransaction().commit();
//        em.getTransaction().rollback();
        return result;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Product.class, id));
        em.getTransaction().commit();
//        em.getTransaction().rollback();
    }
}
