package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Feedback;


public interface FeedbackRepository extends JpaRepository<Feedback, Integer>
{
	Feedback findById(int id);
}
