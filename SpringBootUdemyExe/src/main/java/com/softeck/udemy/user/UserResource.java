package com.softeck.udemy.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDAOservice userDAOservice;

    @GetMapping("/users")
    public List<UserDAO> retriveAllUsers()
    {
        return userDAOservice.findAll();
    }

    @GetMapping("/users/{id}")
    public UserDAOservice retriveUsers(@PathVariable Integer id)
    {
        UserDAO userDAO=UserDAOservice.findOne(id);
        if(userDAO == null) throw new UserNotFoundException("id:-" +id);
        return userDAOservice;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUSer(@Valid @RequestBody UserDAO userDAO)
    {
        UserDAO dao=userDAOservice.save(userDAO);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dao.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id)
    {
        UserDAO userDAO=userDAOservice.deleteByID(id);
        if(userDAO == null)
        {
            throw new UserNotFoundException("id-"+id);
        }
    }
}
