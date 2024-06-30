package pl.example.colors.model;


import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "color", schema = "colors")
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank(message = "Nazwa koloru wymagana")
    @Column(name = "colorName", nullable = false, unique = true)
    private String colorName;

    public Color() {
        // Domyślny konstruktor bezargumentowy (wymagany przez JPA)
    }



    public Color(String colorName) {
        this.colorName = colorName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }





    public @NotBlank(message = "Nazwa koloru wymagana") String getColorName() {
        return colorName;
    }

    public void setColorName(@NotBlank(message = "Nazwa koloru wymagana") String colorName) {
        this.colorName = colorName;
    }
}