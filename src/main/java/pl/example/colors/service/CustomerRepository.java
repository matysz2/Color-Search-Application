package pl.example.colors.service;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.example.colors.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findCustomerByEmail(String email);

    @Query("SELECT c FROM Customer c WHERE c.email = :email AND c.password = :password")
    Customer findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
