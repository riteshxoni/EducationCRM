package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Inquery;
import com.example.repositories.InqueryRepository;

@Service
public class InqueryService 
{
	@Autowired
	InqueryRepository repository;
	
	public void addInquery(Inquery inquery)
	{
		try 
		{
			repository.save(inquery);
		} 
		catch (Exception e) {
			throw new RuntimeException("An Error Occured..."+e.getMessage());
		}
	}
	
	public List<Inquery> findByNumber(String number)
	{
		return repository.findByPhoneno(number);
	}
}
