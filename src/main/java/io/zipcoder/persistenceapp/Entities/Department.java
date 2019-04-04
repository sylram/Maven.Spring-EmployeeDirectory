package io.zipcoder.persistenceapp.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.zipcoder.persistenceapp.Repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Department {


    @Id @GeneratedValue
//    @Column(name="number")
    private Integer number;
    private String name;
//
//    @JsonIgnore
   @OneToMany(mappedBy = "departmentName")
    private Set<Employee> employees;

    @OneToOne(cascade = CascadeType.ALL)
    private Employee manager;


    public Set<Employee> getEmployees() {
        return employees;
    }

//    public void setEmployees(Set<Employee> employees) {
//        this.employees = employees;
//    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }
}
