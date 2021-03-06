package com.epam.lab.mobilepaymentsystem.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Simple JavaBean domain object that represents a User.
 *
 * @author Vladimir Kostin
 * @version 2.0
 */

@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    @Column(name = "bankaccount")
    private Integer bankAccount;

    @Column(name = "username")
    @NotNull
    @Size(min = 5, max = 15)
    private String username;

    @Column(name = "fullname")
    @NotNull
    @Size(min = 2, max = 25)
    private String fullname;

    @Column(name = "password")
    @NotNull
    private String password;

    @Transient
    private String confirmPassword;

    @Column(name = "role")
    private String role;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_services",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "service_id", referencedColumnName = "id"))
    private Set<ServiceUnit> serviceUnits = new HashSet<>();

    public Set<ServiceUnit> getServiceUnits() {
        return serviceUnits;
    }

    public void setServiceUnits(Set<ServiceUnit> serviceUnits) {
        this.serviceUnits = serviceUnits;
    }

    public boolean addService(ServiceUnit serviceUnit) {
        return serviceUnits.add(serviceUnit);
    }

    public boolean removeService(ServiceUnit serviceUnit) {
       return serviceUnits.remove(serviceUnit);
    }

    public User() {
    }

    public Integer getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(Integer bankAccount) {
        this.bankAccount = bankAccount;
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