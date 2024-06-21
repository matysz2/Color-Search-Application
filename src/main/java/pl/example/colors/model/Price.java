package pl.example.colors.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "price", schema = "colors")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "ColorComponent")
    private String colorComponent;

    @Column(name = "price", precision = 8, scale = 6)
    private BigDecimal price;

@Column(name="colorName")
    private String colorName;

    public Price(Long id, String componentQuantity, String colorName, BigDecimal price, String colorComponent) {
        this.id = id;
        this.componentQuantity = componentQuantity;
        this.colorName = colorName;
        this.price = price;
        this.colorComponent = colorComponent;
    }

    @Column(name = "componentQuantity", precision = 8, scale = 6)
    private String componentQuantity;

    public Price(String colorComponent, String componentQuantity, BigDecimal price, String colorName) {
        this.colorComponent = colorComponent;
        this.componentQuantity = componentQuantity;
        this.price = price;
       this.colorName = colorName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComponentQuantity() {
        return componentQuantity;
    }

    public void setComponentQuantity(String componentQuantity) {
        this.componentQuantity = componentQuantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getColorComponent() {
        return colorComponent;
    }

    public void setColorComponent(String colorComponent) {
        this.colorComponent = colorComponent;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
}