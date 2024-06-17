package pl.example.colors.service;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.example.colors.model.Color;

import java.util.List;

public interface ColorRepository extends JpaRepository<Color, Integer> {

    Color findByColorName(String colorName);

    @Query("SELECT c FROM Color c WHERE c.colorName LIKE :start%")
    List<Color> getColorsByColorNameStartsWith(@Param("start") String start);
}
