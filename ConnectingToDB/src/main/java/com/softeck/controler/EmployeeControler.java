package com.softeck.controler;

import com.softeck.exception.notFoundException;
import com.softeck.model.EmployeeEntity;
import com.softeck.repository.EmployeeRepository;
import com.softeck.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeControler {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeRepository repository;

    @RequestMapping("/insert")
    public String insertEmployee()
    {
        return employeeService.employeeDAO();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getvalues")
    public List<EmployeeEntity> getEmployees()
    {
        return repository.findAll();
    }

   @GetMapping("getvalues/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeID(@PathVariable @Valid int id) throws notFoundException {
        EmployeeEntity employeeEntity=repository.findById(id).orElseThrow(()->new notFoundException("id:-" +id));
        return ResponseEntity.ok().body(employeeEntity);
    }

   @PostMapping("/Employees")
    public EmployeeEntity postEmployee(@Valid @RequestBody EmployeeEntity entity)
   {
       return employeeService.postEmployee(entity);
   }


   @PutMapping("/Employees/{id}")
    public EmployeeEntity putEmployees(@RequestBody EmployeeEntity entity, @PathVariable int id)
   {
       return employeeService.updateEmployees(entity,id);
   }

   @DeleteMapping("/Employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
       EmployeeEntity employeeEntity = employeeService.deleteEmployees(id);
       if (employeeEntity == null) {
           throw new notFoundException("id:-" + id);
       }
   }
}
