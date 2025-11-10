package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Employee;
import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
	Employee findByEmail(String email);
	Employee findByPhoneno(String phoneno);
}
