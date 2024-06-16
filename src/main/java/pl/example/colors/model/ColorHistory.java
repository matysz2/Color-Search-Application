package pl.example.colors.model;

import pl.example.colors.model.Color;
import pl.example.colors.model.Customer;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "color_history")
public class ColorHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @Column(name = "search_timestamp")
    private Timestamp searchTimestamp;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private Double quantity;

    // Constructors, getters, setters, and other methods as needed

    // Constructors
    public ColorHistory() {
    }

    public ColorHistory(Customer customer, Color color, Timestamp searchTimestamp, Double price, Double quantity) {
        this.customer = customer;
        this.color = color;
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

    public Timestamp getSearchTimestamp() {
        return searchTimestamp;
    }

    public void setSearchTimestamp(Timestamp searchTimestamp) {
        this.searchTimestamp = searchTimestamp;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}