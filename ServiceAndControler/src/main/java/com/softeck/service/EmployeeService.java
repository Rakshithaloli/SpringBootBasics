package com.softeck.service;

import org.springframework.stereotype.Service;
import com.softeck.model.EmployeeModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class EmployeeService {

    private static List<EmployeeModel> models=new ArrayList<EmployeeModel>();
    int userCount=2;
    static {
        models.add(new EmployeeModel(1, "loli", "loli@gmail", 125.00));
        models.add(new EmployeeModel(2, "Ammu", "ammu@gmail", 155.00));
    }

    public List<EmployeeModel> findAll() {
        return models;
    }


    public static EmployeeModel findOne(int id) {
        for(EmployeeModel employeeModel:models)
        {
            if(employeeModel.getId() == id)
            {
                return employeeModel;
            }
        }
        return null;
    }

    public EmployeeModel addEmployees(EmployeeModel employeeModel) {
        if (employeeModel.getId() == null)
        {
            employeeModel.setId(++userCount);
        }
        models.add(employeeModel);
        return employeeModel;
    }

    public EmployeeModel deleteEmployees(int id) {
        Iterator<EmployeeModel> iterator=models.iterator();
        while (iterator.hasNext())
        {
            EmployeeModel employeeModel1=iterator.next();
            if(employeeModel1.getId()==id)
            {
                iterator.remove();
                return employeeModel1;
            }
        }
        return null;
    }

    public void updateEmployees(EmployeeModel employeeModel, int id) {
        for(int i=0;i<models.size();i++) {
            EmployeeModel model = models.get(i);
            if (model.getId().equals(id)) {
                models.set(i,employeeModel);
            }
        }
    }
}
