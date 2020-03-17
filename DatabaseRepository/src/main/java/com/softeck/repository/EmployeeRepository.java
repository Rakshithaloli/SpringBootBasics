package com.softeck.repository;

import com.softeck.model.EmployeeDAO;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeDAO, Integer> {
}
