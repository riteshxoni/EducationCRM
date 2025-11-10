package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Admin;
import com.example.repositories.AdminRepository;

@Service
public class AdminService 
{
	@Autowired
	AdminRepository repository;
	
	public Admin authentication(String email, String password)
	{
		Admin admin = repository.findByEmail(email);
		if(admin!=null)
		{
			if(admin.getPassword().equals(password))
			{
				return admin;
			}
		}
		return null;
	}
	
	public void updatePassword(Admin admin)
	{
		repository.save(admin);
	}
	
}
