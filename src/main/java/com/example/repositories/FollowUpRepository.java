package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.FollowUps;


public interface FollowUpRepository extends JpaRepository<FollowUps, Long>
{
	FollowUps findByPhoneno(String phoneno);
	List<FollowUps> findByFollowUpDateAndEmployeeEmail(String followUpDate, String employeeEmail);
}
