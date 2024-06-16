package pl.example.colors.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.example.colors.model.Customer;
import pl.example.colors.repository.CustomerRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
@Transactional
public class CustomerDao {

    @PersistenceContext
    private EntityManager entityManager;


    private CustomerRepository customerRepository;

    public void save(Customer customer) {
        entityManager.persist(customer);
    }

    public Customer findById(Long id) {
        return entityManager.find(Customer.class, id);
    }

    public void update(Customer customer) {
        entityManager.merge(customer);
    }

    public void delete(Customer customer) {
        entityManager.remove(entityManager.contains(customer) ? customer : entityManager.merge(customer));
    }

    public Customer findByEmailAndPassword(String email, String password) {
        return customerRepository.findByEmailAndPassword(email, password);
    }
}


