package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repositories.SalesRepository;

@Service
public class SalesService 
{
	@Autowired
	SalesRepository repository;
	
	public String getTotalSalesAmount()
	{
		return repository.findTotalSalesAmount();
	}
	
	public String getTotalEmployeeSalesAmount()
	{
		return repository.findTotalEmployeeSalesAmount();
	}
	
	public List<Object[]> findEachEmployeeWithTotalSales()
	{
		return repository.findEachEmployeeWithTotalSales();
	}
}
