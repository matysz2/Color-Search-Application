package pl.example.colors.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.example.colors.model.ColorHistory;
import pl.example.colors.model.Customer;

import java.util.List;

public interface ColorHistoryRepository extends JpaRepository<ColorHistory, Integer> {

    // Metoda do wyszukiwania wszystkich kolorów dla danego klienta
    List<ColorHistory> findByCustomer(Customer customer);

    // Możesz dodać dodatkowe metody zapytań według potrzeb
    @Query("SELECT ch FROM ColorHistory ch WHERE ch.customer = :customer")
    List<ColorHistory> findColorHistoriesByCustomer(@Param("customer") Customer customer);

}
