package pl.example.colors.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "color")
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String colorName;

    @OneToMany(mappedBy = "color", cascade = CascadeType.ALL)
    private List<ComponentsPrice> colorPrices;

    public Color() {
    }

    public Color(String colorName) {
        this.colorName = colorName;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public List<ComponentsPrice> getColorPrices() {
        return colorPrices;
    }

    public void setColorPrices(List<ComponentsPrice> colorPrices) {
        this.colorPrices = colorPrices;
    }

}
