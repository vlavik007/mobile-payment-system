package com.epam.lab.mobilepaymentsystem.model;

import javax.persistence.*;
import java.util.List;

/**
 * Simple JavaBean domain object that represents a User.
 *
 * @author Vladimir Kostin
 * @version 2.0
 */

@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    @Column(name = "bankbook")
    private Integer bankBook;

    @Column(name = "username")
    private String username;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "password")
    private String password;

    @Transient
    private String confirmPassword;

    @Column(name = "role")
    private String role;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_services",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "service_id", referencedColumnName = "id"))
    private List<ServiceUnit> serviceUnits;

    public List<ServiceUnit> getServiceUnits() {
        return serviceUnits;
    }

    public void setServiceUnits(List<ServiceUnit> serviceUnits) {
        this.serviceUnits = serviceUnits;
    }

    public User() {
    }

    public Integer getBankBook() {
        return bankBook;
    }

    public void setBankBook(int bankBook) {
        this.bankBook = bankBook;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}