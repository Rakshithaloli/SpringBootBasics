package com.softeck.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "EMPLOYEE")
public class EmployeeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "NAME",nullable = false)
    private String name;

    @Column(name = "EMAIL", nullable = false, length = 200)
    private String email;


    public EmployeeEntity(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
