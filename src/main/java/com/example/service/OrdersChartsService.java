package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repositories.OrdersChartRepository;

@Service
public class OrdersChartsService 
{
	@Autowired
	OrdersChartRepository chartRepository;
	
	public List<Object[]> getSalesPerDate()
	{
		return chartRepository.findSalesPerDate();
	}
	
	public List<Object[]> findCourseWithSales()
	{
		return chartRepository.findCourseWithSales();
	}
	
	public List<Object[]> findDateAmountOfSales()
	{
		return chartRepository.findDateAmountOfSales();
	}
}
