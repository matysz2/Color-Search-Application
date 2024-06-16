package pl.example.colors.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "price")
public class ComponentsPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ColorComponent")
    private String ColorComponent;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "colorName", referencedColumnName = "id")
    private Color color;

    @Column(name = "componentQuantity")
    private double componentQuantity;

    public ComponentsPrice() {
    }

    public ComponentsPrice(Long id, String colorComponent, Double price, Color color, double componentQuantity) {
        this.id = id;
        ColorComponent = colorComponent;
        this.price = price;
        this.color = color;
        this.componentQuantity = componentQuantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColorComponent() {
        return ColorComponent;
    }

    public void setColorComponent(String colorComponent) {
        ColorComponent = colorComponent;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getComponentQuantity() {
        return componentQuantity;
    }

    public void setComponentQuantity(double componentQuantity) {
        this.componentQuantity = componentQuantity;
    }
}
