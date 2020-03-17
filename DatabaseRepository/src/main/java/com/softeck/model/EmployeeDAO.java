package com.softeck.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Employee")
public class EmployeeDAO {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "NAME",nullable = false)
    private String name;

    @Column(name = "EMAIL", nullable = false, length = 200)
    private String email;

    public EmployeeDAO(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeDAO)) return false;
        EmployeeDAO that = (EmployeeDAO) o;
        return getId().equals(that.getId()) &&
                getName().equals(that.getName()) &&
                getEmail().equals(that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail());
    }

    @Override
    public String toString() {
        return "EmployeeDAO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
