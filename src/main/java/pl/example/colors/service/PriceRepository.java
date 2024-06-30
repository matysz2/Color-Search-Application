package pl.example.colors.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.example.colors.model.Color;
import pl.example.colors.model.Price;

import java.util.List;


public interface PriceRepository extends JpaRepository<Price, Long> {

    boolean existsByColorName(String colorName);

    @Query("SELECT p.colorComponent, p.componentQuantity, p.price, p.colorName FROM Price p WHERE p.colorName LIKE %:colorName%")
    List<Object[]> findComponentsAndQuantityAndPriceByColorName(@Param("colorName") String colorName);
}

