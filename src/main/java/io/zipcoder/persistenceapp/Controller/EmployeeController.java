package io.zipcoder.persistenceapp.Controller;

import io.zipcoder.persistenceapp.Entities.Department;
import io.zipcoder.persistenceapp.Entities.Employee;
import io.zipcoder.persistenceapp.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

@Autowired
    EmployeeRepo employeeRepo;

    @PostMapping("/employee")
    ResponseEntity<Employee> create(@RequestBody Employee employee){
    employeeRepo.save(employee);
    return new ResponseEntity<>(employeeRepo.save(employee), HttpStatus.CREATED);
    }

    @GetMapping("/employee/{id}")
    ResponseEntity<Employee> getEmployee(@PathVariable Integer id){
        return new ResponseEntity<>(employeeRepo.findOne(id), HttpStatus.OK);
    }

    @PutMapping("/employee/{id}")
    ResponseEntity<Employee> getEmployee(@PathVariable Integer id,@RequestBody Employee employee){
//        id = employeeRepo.findOne(id).getId();
        employee.setId(id);
        return new ResponseEntity<Employee>(employeeRepo.save(employee), HttpStatus.OK);
    }
    @DeleteMapping("/employee/{id}")
    @ResponseStatus(value =  HttpStatus.NO_CONTENT)
    public void DeleteEmployee(@PathVariable Integer id){
        employeeRepo.delete(id);
    }

    @PutMapping("/employee/department/{id}")
    ResponseEntity<Employee> getEmployee(@PathVariable Integer id,
                                         @RequestBody Department department){

    Employee employee = employeeRepo.findOne(id);
    employee.setDepartmentName(department);

        return new ResponseEntity<Employee>(employeeRepo.save(employee), HttpStatus.OK);
    }



}
