package pl.example.colors.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "color_history", schema = "colors")
public class ColorHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_id")
    private Color color;

    @Column(name = "search_timestamp")
    private Instant searchTimestamp;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private Double quantity;

    public ColorHistory() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Instant getSearchTimestamp() {
        return searchTimestamp;
    }

    public void setSearchTimestamp(Instant searchTimestamp) {
        this.searchTimestamp = searchTimestamp;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public ColorHistory(Integer id, Instant searchTimestamp, Double price, Double quantity, Color color, Customer customer) {
        this.id = id;
        this.searchTimestamp = searchTimestamp;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.customer = customer;
    }
}