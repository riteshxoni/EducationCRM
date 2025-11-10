package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entities.Orders;

public interface OrdersChartRepository extends JpaRepository<Orders, Long>
{
	@Query(value = "select substring_index(date_of_purchase, ',' , 1) as purchase_date,count(*) as sales from orders group by purchase_date order by purchase_date", nativeQuery = true)
	List<Object[]> findSalesPerDate();
	
	@Query(value = "select course_name, count(*) as total_sold from orders group by course_name", nativeQuery = true)
	List<Object[]> findCourseWithSales();
	
	@Query(value = "select substring_index(date_of_purchase, ',', 1) as SalesDate, sum(course_price) as SalesAmount from orders group by SalesDate order by SalesDate", nativeQuery = true)
	List<Object[]> findDateAmountOfSales();
}

