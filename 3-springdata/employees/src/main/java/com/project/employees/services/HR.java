package com.project.employees.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.employees.models.Employee;
import com.project.employees.repositories.EmployeeRepo;

@Service
public class HR {
	
	private EmployeeRepo repo;
	public HR(EmployeeRepo repo) {
		this.repo = repo;
	}
		
	public Employee create(Employee employee) {return repo.save(employee);}
	public Employee get(Long id) {return repo.findOne(id);}
	public Employee update(Employee employee) {return repo.save(employee);}
	public void delete(Employee employee) {repo.delete(employee);}
	
	public List<Employee> all() {return repo.findAll();} // all workers
	public List<Employee> managers() {return repo.findByPromoted(true);} // managers only
	public List<Employee> employees() {return repo.findByPromoted(false);} // managers only
	
	public List<Employee> team(Employee manager) {return repo.findByManager(manager);}
	
	public boolean exists(Long id) {return repo.existsById(id);}
	
	public void promote(Employee manager) {
		manager.setPromoted(true);
		repo.save(manager);
	}
	
	public void assign(Employee employee, Employee manager) {
		employee.setManager(manager);
		repo.save(employee);
	}
	
}
