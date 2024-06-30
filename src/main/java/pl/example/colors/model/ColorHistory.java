package pl.example.colors.model;

import jakarta.persistence.*;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import java.time.Instant;

@Setter
@Entity
@Table(name = "color_history", schema = "colors")
public class ColorHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    @NotNull(message = "Id klienta wymagane")
    private Customer customer;

    @Size(min = 1, max = 100, message = "Kolor musi mieć od 1 do 100 znaków")
    private String colorName;

    @Column(name = "search_timestamp", nullable = false)
    @NotNull(message = "Data jest wymagana")
    private String searchTimestamp;

    @Column(name = "price")
    @Positive(message = "Cena musi być dodatnia")
    private Double price;

    @Column(name = "quantity")
    @Positive(message = "Ilość musi być liczbą dodatnią")
    private Double quantity;

    public ColorHistory() {

    }

    public ColorHistory(Customer customer, String colorName, String searchTimestamp, Double price, Double quantity) {
        this.customer = customer;
        this.colorName = colorName;
        this.searchTimestamp = searchTimestamp;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSearchTimestamp() {
        return searchTimestamp;
    }

    public void setSearchTimestamp(String searchTimestamp) {
        this.searchTimestamp = searchTimestamp;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}