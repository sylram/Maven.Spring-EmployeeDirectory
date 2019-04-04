package io.zipcoder.persistenceapp.Repository;

import io.zipcoder.persistenceapp.Entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee,Integer> {


     //List<Employee> findAllByDepartmentName(Integer id);
}
