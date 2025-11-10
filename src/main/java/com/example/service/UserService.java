package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.entities.User;
import com.example.repositories.UserRepository;

@Service
public class UserService 
{
	@Autowired
	UserRepository repository;
	
//	Create
	public boolean registerUser(User user)
	{
		try 
		{
			repository.save(user);
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
//	get and validate
	public User authenticate(String email, String password)
	{
		User user = repository.findByEmail(email);
		
		if(user != null)
		{
			if(user.getPassword().equals(password))
			{
				return user;
			}
		}
		
		return null;
	}
	
	public User findUserByEmail(String email)
	{
		return repository.findByEmail(email);
	}
	
	public User findUserByPhone(String phoneno)
	{
		return repository.findByPhoneno(phoneno);
	}
	
	public User findUserById(int id)
	{
		return repository.findById(id);
	}
	
	public Page<User> getAllUsers(Pageable pageable)
	{
		return repository.findAll(pageable);
	}
	
	public void updateUser(User user)
	{
		try 
		{
			repository.save(user);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
