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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "colorName")
    private Color colorName;

    public Price(Long id, BigDecimal componentQuantity, Color colorName, BigDecimal price, String colorComponent) {
        this.id = id;
        this.componentQuantity = componentQuantity;
        this.colorName = colorName;
        this.price = price;
        this.colorComponent = colorComponent;
    }

    @Column(name = "componentQuantity", precision = 8, scale = 6)
    private BigDecimal componentQuantity;

    public Price() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColorComponent() {
        return colorComponent;
    }

    public void setColorComponent(String colorComponent) {
        this.colorComponent = colorComponent;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Color getColorName() {
        return colorName;
    }

    public void setColorName(Color colorName) {
        this.colorName = colorName;
    }

    public BigDecimal getComponentQuantity() {
        return componentQuantity;
    }

    public void setComponentQuantity(BigDecimal componentQuantity) {
        this.componentQuantity = componentQuantity;
    }

}