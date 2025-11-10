package com.example.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Feedback;
import com.example.service.FeedbackService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class FeedbackApi 
{
	@Autowired
	FeedbackService feedbackService;
	
	@GetMapping("/getFeedback")
	public ResponseEntity<List<Feedback>> getFeedback(@RequestParam("feedbackId") int id, HttpSession session)
	{	
		if(session.getAttribute("admin")!=null)
		{
			Feedback feedback = feedbackService.getFeedback(id);
			List<Feedback> list = new ArrayList<>();
			list.add(feedback);
			return ResponseEntity.ok(list);
		}
		
		return ResponseEntity.ok(null);
	}
}
