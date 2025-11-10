package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long>
{
	String JoinQuery = "SELECT c.name,c.image_url,c.description,c.updated_on,"
			+ "o.date_of_purchase,o.course_price,o.order_id "
			+ "FROM course c JOIN orders o ON c.name = o.course_name "
			+ "WHERE o.user_email = :email";
	
	@Query(value = JoinQuery, nativeQuery = true)
	List<Object[]> findOrderedCoursesByEmail(@Param("email") String email);
	
	List<Orders> findByUserEmail(String userEmail);
	
}
