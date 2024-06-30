package pl.example.colors.model;

import jakarta.persistence.*;

import javax.validation.constraints.*;
import java.util.List;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    private String password;

    @NotEmpty(message = "firstName cannot be empty")
    private String firstName;

    @NotEmpty(message = "lastName cannot be empty")
    private String lastName;

    @NotEmpty(message = "Address cannot be empty")
    private String address;

    @NotEmpty(message = "Phone number cannot be empty")
    private String phoneNumber;

    @OneToMany(mappedBy = "customer")
    private Set<ColorHistory> colorHistories;

    @OneToMany(mappedBy = "customer")
    private List<Comment> comments;

    public Customer(Integer id, String email, String firstName, String password, String lastName, String address, String phoneNumber, Set<ColorHistory> colorHistories) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.password = password;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.colorHistories = colorHistories;
    }

    public Customer() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotEmpty(message = "Email cannot be empty") @Email(message = "Email should be valid") String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty(message = "Email cannot be empty") @Email(message = "Email should be valid") String email) {
        this.email = email;
    }

    public @NotEmpty(message = "Password cannot be empty") String getPassword() {
        return password;
    }

    public void setPassword(@NotEmpty(message = "Password cannot be empty") String password) {
        this.password = password;
    }

    public @NotEmpty(message = "firstName cannot be empty") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotEmpty(message = "firstName cannot be empty") String firstName) {
        this.firstName = firstName;
    }

    public @NotEmpty(message = "lastName cannot be empty") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotEmpty(message = "lastName cannot be empty") String lastName) {
        this.lastName = lastName;
    }

    public @NotEmpty(message = "Address cannot be empty") String getAddress() {
        return address;
    }

    public void setAddress(@NotEmpty(message = "Address cannot be empty") String address) {
        this.address = address;
    }

    public @NotEmpty(message = "Phone number cannot be empty") String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NotEmpty(message = "Phone number cannot be empty") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<ColorHistory> getColorHistories() {
        return colorHistories;
    }

    public void setColorHistories(Set<ColorHistory> colorHistories) {
        this.colorHistories = colorHistories;
    }
}

