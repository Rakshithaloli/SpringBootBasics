package com.softeck.udemy.helloworld;

import com.softeck.udemy.user.UserDAO;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends CrudRepository<UserDAO, Integer> {

}
