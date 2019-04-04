package io.zipcoder.persistenceapp.Controller;

import io.zipcoder.persistenceapp.Entities.Department;
import io.zipcoder.persistenceapp.Entities.Employee;
import io.zipcoder.persistenceapp.Repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentRepo departmentRepo;


    @PostMapping("/department")
    ResponseEntity<Department> create(@RequestBody Department department){
        departmentRepo.save(department);
        return new ResponseEntity<>(departmentRepo.save(department), HttpStatus.CREATED);
    }
    @GetMapping("/department/{id}")
    ResponseEntity<Department> getEmployee(@PathVariable Integer id){
        return new ResponseEntity<>(departmentRepo.findOne(id), HttpStatus.OK);
    }

    @PutMapping("/department/{id}")
    ResponseEntity<Department> getEmployee(@PathVariable Integer id,@RequestBody Department department){
//        id = departmentRepo.findOne(id).getNumber();
       department.setNumber(id);
        return new ResponseEntity<>(departmentRepo.save(department), HttpStatus.OK);
    }
    @DeleteMapping("/department/{id}")
    @ResponseStatus(value =  HttpStatus.NO_CONTENT)
    public void DeleteEmployee(@PathVariable Integer id){
        departmentRepo.delete(id);
    }
    @GetMapping("/department/employees/{id}")
    ResponseEntity<Set<Employee>> getEmployees(@PathVariable Integer id){
        Department dept = departmentRepo.findOne(id);
        return new ResponseEntity<>(dept.getEmployees(), HttpStatus.OK);
    }

}
