package com.softeck.controler;

import com.softeck.controler.exception.employeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.softeck.model.EmployeeModel;
import com.softeck.service.EmployeeService;

import java.util.List;

@RestController
class EmployeeControler {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/Employees")
    public List<EmployeeModel> getEmployees()
    {
        return employeeService.findAll();
    }

    @GetMapping("/Employees/{id}")
    public EmployeeModel getOneEmployee(@PathVariable int id)
    {
       EmployeeModel employeeModel=employeeService.findOne(id);
        if(employeeModel == null)
        {
            throw new employeeNotFoundException("id :-" +id);
        }
        return employeeModel;
    }


    @RequestMapping(method = RequestMethod.POST,value = "/Employees")
    public void addEmployees(@RequestBody EmployeeModel employeeModel)
    {
        employeeService.addEmployees(employeeModel);
    }

   @DeleteMapping("/Employees/{id}")
    public void deleteEmployees(@PathVariable int id)
    {
        EmployeeModel employeeModel1=employeeService.deleteEmployees(id);
       if(employeeModel1 == null)
        {
            throw new employeeNotFoundException("id :-" +id);
        }
    }


    @PutMapping("/Employees/{id}")
    public void updateEmployees(@RequestBody EmployeeModel employeeModel,@PathVariable int id)
    {
        employeeService.updateEmployees(employeeModel,id);
    }
}
