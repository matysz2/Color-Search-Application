package pl.example.colors.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.example.colors.model.ColorHistory;
import pl.example.colors.model.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findCustomerByEmail(String email);

    @Query("SELECT c FROM Customer c WHERE c.email = :email AND c.password = :password")
    Customer findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    // Corrected method name to match the query
    @Query("SELECT c FROM Customer c WHERE c.email = :email AND c.firstName = :firstName")
    Customer findCustomerByEmailAndFirstName(@Param("email") String email, @Param("firstName") String firstName);

    // Corrected to retrieve Customer first, then ColorHistory if needed
    @Query("SELECT ch FROM ColorHistory ch WHERE ch.customer.id = :customerId")
    List<ColorHistory> findColorHistoriesByCustomerId(@Param("customerId") Integer customerId);
}
