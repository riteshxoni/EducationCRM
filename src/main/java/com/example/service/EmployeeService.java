package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.entities.Employee;
import com.example.repositories.EmployeeRepository;

@Service
public class EmployeeService 
{
	@Autowired
	EmployeeRepository repository;
	
	public Page<Employee> getEmployeesByPagination(Pageable pageable)
	{
		return repository.findAll(pageable);
	}
	
	public void addEmployee(Employee employee)
	{
		Employee emp = repository.findByEmail(employee.getEmail());
		if(emp!=null)
		{
			throw new RuntimeException("Email Already exists");
		}
		
		emp =repository.findByPhoneno(employee.getPhoneno());
		if(emp!=null)
		{
			throw new RuntimeException("Phone No Already exists");
		}
		repository.save(employee);
	}
	
	public Employee getEmployeeByEmail(String email)
	{
		return repository.findByEmail(email);
	}
	
	public Employee getEmployeeByPhone(String phoneno)
	{
		return repository.findByPhoneno(phoneno);
	}
	
	public void editEmployee(Employee employee)
	{
		try 
		{
			repository.save(employee);
		} 
		catch (Exception e) 
		{
			throw new RuntimeException("Some error " + e.getMessage());
		}
	}
	
	public boolean deleteEmployee(String email)
	{
		Employee employee = repository.findByEmail(email);
		if(employee!=null)
		{
			
			repository.delete(employee);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Employee validateEmployee(String email, String password)
	{
		Employee employee = repository.findByEmail(email);
		if(employee!=null)
		{
			if(employee.getPassword().equals(password))
			{
				return employee;
			}
		}
		return null;
	}
}
