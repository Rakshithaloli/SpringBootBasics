package com.softeck.service;

import com.softeck.model.EmployeeEntity;
import com.softeck.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    List<EmployeeEntity> employeeEntityList = new ArrayList<EmployeeEntity>();
    int userCount=4;

    public String employeeDAO()
    {

        employeeEntityList.add(new EmployeeEntity(101,"Ammu","ammu@gmail.com"));
        employeeEntityList.add(new EmployeeEntity(102,"Raghu","raghu@gmail.com"));
        employeeEntityList.add(new EmployeeEntity(103,"Girija","girija@gmail.com"));
        employeeEntityList.add(new EmployeeEntity(104,"loli","loli@gmail.com"));
        employeeEntityList.stream().forEach(employee->{repository.save(employee); });
        return "inserted successfully";

    }

    //GETMAPPING(FINDALL)
    public List<EmployeeEntity> getEmployees() {
        return  repository.findAll();
    }

    //GETMAPPING(FINDONE)
    public Optional<EmployeeEntity> getEmployeeID(int id) {
        return repository.findById(id);
    }


    //POSTMAPPING
    public EmployeeEntity postEmployee(EmployeeEntity entity) {
            if(entity.getId()==null)
            {
                entity.setId(++userCount);
            }
           repository.save(entity);
            return entity;
    }

    //PUTMAPPING
    public EmployeeEntity updateEmployees(EmployeeEntity entity, int id) {
       // return repository.save(entity);
      for (int i=0;i<employeeEntityList.size();i++)
        {
                EmployeeEntity employeeEntity=employeeEntityList.get(i);
                if(employeeEntity.getId().equals(id))
                {
                    EmployeeEntity set=employeeEntityList.set(i,entity);
                    return repository.save(set);
                }
        }
        return repository.save(entity);
    }

    public EmployeeEntity deleteEmployees(int id) {
        repository.deleteById(id);
      /*Iterator<EmployeeEntity> employeeEntities=employeeEntityList.iterator();
      while (employeeEntities.hasNext())
      {
          EmployeeEntity employeeEntity=employeeEntities.next();
          if(employeeEntity.getId().equals(id))
          {
              employeeEntities.remove();
              return employeeEntity;
          }
      }
      return null;*/
        return null;
    }
}
