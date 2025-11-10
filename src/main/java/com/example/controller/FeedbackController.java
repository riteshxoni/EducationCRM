package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.entities.Feedback;
import com.example.service.FeedbackService;

import jakarta.servlet.http.HttpSession;

@Controller
public class FeedbackController {
	
	@Autowired
	FeedbackService feedbackService;
	
	@GetMapping("/feedback")
	public String feedbackForm(Model model, HttpSession session,RedirectAttributes attributes)
	{
		if(session.getAttribute("sessionUser")==null)
		{
			attributes.addFlashAttribute("error", "Please Login First");
			return "redirect:/login";
		}
		model.addAttribute("sessionUser", session.getAttribute("sessionUser"));
		model.addAttribute("feedback", new Feedback());
		return "/customer/feedback";
	}
	
	@PostMapping("/feedback")
	public String addFeedback(@ModelAttribute("feedback") Feedback feedback, HttpSession session, RedirectAttributes attributes)
	{
		if(session.getAttribute("sessionUser")!=null)
		{
			try 
			{
				feedbackService.addFeedback(feedback);
				attributes.addFlashAttribute("success", "Feedback send successfully...");
			} 
			catch (Exception e) 
			{
				attributes.addFlashAttribute("error", "Feedback send failed..."+e.getMessage());
			}
		}
		return "redirect:/feedback";
	}
	
	@GetMapping("/admin/feedback")
	public String feedback(@RequestParam(name = "page", defaultValue = "0") int page, 
			@RequestParam(name = "size", defaultValue = "5") int size, Model model, 
			HttpSession session, RedirectAttributes attributes)
	{
		if(session.getAttribute("admin")==null)
		{
			attributes.addFlashAttribute("error", "Login First to Access Admin Dashboard");
			return "redirect:/admin/login";
		}
		
		Pageable pageable = PageRequest.of(page, size);
		Page<Feedback> feedbacks = feedbackService.getAllFeedbacks(pageable);
		
		model.addAttribute("feedbacks", feedbacks);
		
		return "admin/pages/feedback";
	}
	
	@GetMapping("/admin/readStatus")
	public String changeStatus(@RequestParam("id")int id, @RequestParam("status") boolean status, HttpSession session)
	{
		if(session.getAttribute("admin")!=null) {
			
			Feedback feedback = feedbackService.getFeedback(id);
			feedback.setStatus(status);
			feedbackService.addFeedback(feedback);			
		}
		return "redirect:/admin/feedback";
	}
	

}
