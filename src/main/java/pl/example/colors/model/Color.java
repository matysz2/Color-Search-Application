package pl.example.colors.model;

import jakarta.persistence.*;

@Entity
@Table(name = "color", schema = "colors")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "colorName", nullable = false)
    private String colorName;

    public Color() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public Color(Integer id, String colorName) {
        this.id = id;
        this.colorName = colorName;
    }
}