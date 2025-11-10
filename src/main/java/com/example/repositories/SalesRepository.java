package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entities.Orders;

public interface SalesRepository extends JpaRepository<Orders, Long>
{
	@Query(value = "select sum(course_price) from orders", nativeQuery = true)
	String findTotalSalesAmount();
	
	@Query(value = "select sum(course_price) from orders where employee_email <> 'null'", nativeQuery = true)
	String findTotalEmployeeSalesAmount();
	
	@Query(value = "SELECT e.name,e.email,e.phoneno, SUM(o.course_price) FROM employee e JOIN orders o ON e.email=o.employee_email GROUP BY e.name,e.email,e.phoneno", nativeQuery = true)
	List<Object[]> findEachEmployeeWithTotalSales();
	
	
}
