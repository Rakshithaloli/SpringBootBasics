package com.softeck.controler;

import com.softeck.model.EmployeeDAO;
import com.softeck.service.ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeControler {

    @Autowired(required = true)
    private ServiceClass serviceClass;

    @PostMapping("/Employee")
    public void postEmployees(@RequestBody EmployeeDAO dao)
    {
        serviceClass.addEmployee(dao);
    }

    @RequestMapping("/Employee")
    public void getEmployees()
    {
      serviceClass.findAll();
    }
}
