package com.softeck.udemy.user;


import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class UserDAO {
    private Integer id;
    @Size(min = 3)
    private String name;
    @Past
    private Date date;

    public UserDAO(int id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
