package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.OrderedCourse;
import com.example.entities.Course;
import com.example.entities.Orders;
import com.example.repositories.OrdersRepository;

@Service
public class OrderService 
{
	@Autowired
	private OrdersRepository repository;
	
	public void createUserOrder(Orders order)
	{
		repository.save(order);
	}
	
	
	public List<OrderedCourse> getOrderedCourses(String email)
	{
		List<Object[]> orderedCourses = repository.findOrderedCoursesByEmail(email);
		
		List<OrderedCourse> list = new ArrayList<>();
		
		for(Object[] course : orderedCourses)
		{
			OrderedCourse orderedCourse = new OrderedCourse();
			
			orderedCourse.setName((String) course[0]);
			orderedCourse.setImage_url((String) course[1]);
			orderedCourse.setDescription((String) course[2]);
			orderedCourse.setUpdated_on((String) course[3]);
			orderedCourse.setDate_of_purchase((String) course[4]);
			orderedCourse.setCourse_price((String) course[5]);
			orderedCourse.setOrder_id((String) course[6]);
			
			list.add(orderedCourse);
		}
		return list;
	}
	
	public List<String> getPurchasedNamesByEmail(String email)
	{
		List<Orders> list = repository.findByUserEmail(email);
		List<String> names = new ArrayList<>();
		
		for(Orders order : list)
		{
			names.add(order.getCourseName());
		}
		return names;
	}
	
	public List<Orders> findCoursesByEmail(String email)
	{
		return repository.findByUserEmail(email);
	}
}
