package com.project.employees.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.employees.models.Employee;

@Repository 												
public interface EmployeeRepo extends CrudRepository<Employee,Long>{
	
	List<Employee> findAll(); // find all employees
	
	List<Employee> findByManager(Employee manager);

	List<Employee> findByPromoted(boolean promoted); // retrieve list of only managers
	
	boolean existsById(Long id); // check if Employee exists by id
	
}
