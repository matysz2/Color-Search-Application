package pl.example.colors.model;
import jakarta.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
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

    @NotEmpty(message = "Pole nie może być puste")
    @Min(value = 8, message = "Proszę wybrać wyświetlany kolor")
    @Column(name = "colorName")
    private String colorName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_id") // nazwa kolumny w tabeli "price", która przechowuje klucz obcy do tabeli "color"
    private Color color;

    public Price(Long id, String componentQuantity, String colorName, BigDecimal price, String colorComponent, Color color) {
        this.id = id;
        this.componentQuantity = componentQuantity;
        this.colorName = colorName;
        this.color = color;
        this.price = price;
        this.colorComponent = colorComponent;
    }

    @Column(name = "componentQuantity", precision = 8, scale = 6)
    private String componentQuantity;

    public Price(String colorComponent, String componentQuantity, BigDecimal price, String colorName) {
        this.colorComponent = colorComponent;
        this.componentQuantity = componentQuantity;
        this.price = price;
        this.id=getId();
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public @NotEmpty(message = "Pole nie może być puste") @Min(value = 8, message = "Proszę wybrać wyświetlany kolor") String getColorName() {
        return colorName;
    }

    public void setColorName(@NotEmpty(message = "Pole nie może być puste") @Min(value = 8, message = "Proszę wybrać wyświetlany kolor") String colorName) {
        this.colorName = colorName;
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
}

