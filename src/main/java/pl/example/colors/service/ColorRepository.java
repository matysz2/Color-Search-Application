package pl.example.colors.service;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.example.colors.model.Color;
import pl.example.colors.model.Price;

import java.math.BigDecimal;
import java.util.List;


public interface ColorRepository extends JpaRepository<Color, Integer> {
    Color findByColorName(String colorName);

    @Query("SELECT c FROM Color c WHERE c.colorName LIKE %:fragment%")
    List<Color> findColorsByColorNameContains(@Param("fragment") String fragment);

    @Query("SELECT c.colorName FROM Color c WHERE c.id = :id")
    String findColorNameById(@Param("id") Integer id);

}