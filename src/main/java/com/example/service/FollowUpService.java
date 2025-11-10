package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.FollowUps;
import com.example.repositories.FollowUpRepository;

@Service
public class FollowUpService 
{
	@Autowired
	FollowUpRepository repository;
	
	public void addFollowUp(FollowUps followUp)
	{
		try 
		{
			FollowUps followUpOld = repository.findByPhoneno(followUp.getPhoneno());
			if(followUpOld!=null)
			{
				followUpOld.setFollowUpDate(followUp.getFollowUpDate());
				repository.save(followUpOld);
			}
			else
			{
				repository.save(followUp);
			}
		} 
		catch (Exception e) 
		{
			throw new RuntimeException("An Error Occured..."+e.getMessage());
		}
	}
	
	public List<FollowUps> getByDateAndEmpEmail(String date, String employeeEmail)
	{
		return repository.findByFollowUpDateAndEmployeeEmail(date, employeeEmail);
	}
	
	public void deleteFollowUp(String phoneno)
	{
		FollowUps followUp = repository.findByPhoneno(phoneno);
		if(followUp!=null)
		{
			repository.delete(followUp);
		}
	}
}
