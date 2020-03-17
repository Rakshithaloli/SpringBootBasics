package com.softeck.service;

import com.softeck.model.EmployeeDAO;
import com.softeck.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public  class ServiceClass {
    @Autowired(required = true)
    private EmployeeRepository employeeRepository;

    private List<EmployeeDAO> employeeDAOS=new ArrayList<EmployeeDAO>();
    int userCount=0;

    public EmployeeDAO addEmployee(EmployeeDAO dao)
    {
        if (dao.getId() == null)
        {
            dao.setId(++userCount);
        }
        employeeDAOS.add(dao);
        return dao;
    }

   public List<EmployeeDAO> findAll()
   {
       return employeeDAOS;
   }
}

