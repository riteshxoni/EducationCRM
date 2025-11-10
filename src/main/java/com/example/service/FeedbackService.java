package com.example.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.entities.Feedback;
import com.example.repositories.FeedbackRepository;

@Service
public class FeedbackService {
	
	@Autowired
	FeedbackRepository feedbackRepository;
	
	public void addFeedback(Feedback feedback)
	{
		feedbackRepository.save(feedback);
	}
	
	public Page<Feedback> getAllFeedbacks(Pageable pageable)
	{
		return feedbackRepository.findAll(pageable);
	}
	
	public Feedback getFeedback(int id)
	{
		return feedbackRepository.findById(id);
	}
}
