package pl.example.colors.repository;



import org.springframework.stereotype.Repository;
import pl.example.colors.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Customer findByEmailAndPassword(String email, String password) {
        try {
            return entityManager.createQuery("SELECT c FROM Customer c WHERE c.email = :email AND c.password = :password", Customer.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // Jeśli nie znaleziono pasującego użytkownika, zwracamy null
        }
    }
}