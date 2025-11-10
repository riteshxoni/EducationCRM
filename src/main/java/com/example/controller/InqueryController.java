package com.example.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.entities.Employee;
import com.example.entities.FollowUps;
import com.example.entities.Inquery;
import com.example.service.CourseService;
import com.example.service.FollowUpService;
import com.example.service.InqueryService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/employee")
public class InqueryController {
	
	@Autowired
	CourseService courseService;
	@Autowired
	InqueryService inqueryService;
	@Autowired
	FollowUpService followUpService;
	
	@GetMapping("/inquery")
	public String inqueryPage(Model model, HttpSession session)
	{
		Employee employee = (Employee) session.getAttribute("employee");
		if(employee!=null)
		{
			model.addAttribute("employee", employee);
			model.addAttribute("inquery", new Inquery());
			model.addAttribute("courseNames", courseService.getCourseNames());
			return "/employee/inquery";
		}
		else
		{
			return "redirect:/employee/login";
		}
	}
	
	@GetMapping("/newInquery")
	public String newInqueryForm(Model model, HttpSession session)
	{
		Employee employee = (Employee) session.getAttribute("employee");
		if(employee!=null)
		{
			model.addAttribute("courseNames", courseService.getCourseNames());
			model.addAttribute("inquery", new Inquery());
			model.addAttribute("employee", employee);
			return "/employee/newInquery";
		}
		else
		{
			return "redirect:/employee/login";
		}
	}
	
	@PostMapping("/addInquery")
	public String addInquery(@ModelAttribute("inquery")Inquery inquery, 
			@RequestParam(name = "followUpDate", required = false) String followUpDate, Model model, 
			HttpSession session, RedirectAttributes attributes)
	{
		Employee employee = (Employee) session.getAttribute("employee");
		inquery.setEmployeeEmail(employee.getEmail());
		inquery.setInqueryDate(new Date());
		
		try 
		{
			inqueryService.addInquery(inquery);
			if(inquery.getStatus().equals("Intrested-(Follow Up)") && followUpDate != null)
			{
				FollowUps followUp = new FollowUps();
				followUp.setFollowUpDate(followUpDate);
				followUp.setEmployeeEmail(employee.getEmail());
				followUp.setPhoneno(inquery.getPhoneno());
				followUpService.addFollowUp(followUp);
			}
			
			attributes.addFlashAttribute("success", "Inquery Added Successfully...");
		} 
		catch (Exception e) 
		{
			attributes.addFlashAttribute("error", "Failed to add Inquery..."+e.getMessage());
		}
		return "redirect:/employee/newInquery";
	}
	
	@PostMapping("/continueInquery")
	public String continueInquery(@ModelAttribute("inquery")Inquery inquery, 
			@RequestParam(name = "followUpDate", required = false) String followUpDate, Model model, 
			HttpSession session, RedirectAttributes attributes)
	{		
		Employee employee = (Employee) session.getAttribute("employee");
		inquery.setEmployeeEmail(employee.getEmail());
		inquery.setInqueryDate(new Date());
		
		try 
		{
			inqueryService.addInquery(inquery);
			if(inquery.getStatus().equals("Intrested-(Follow Up)") && followUpDate != null)
			{
				FollowUps followUp = new FollowUps();
				followUp.setFollowUpDate(followUpDate);
				followUp.setEmployeeEmail(employee.getEmail());
				followUp.setPhoneno(inquery.getPhoneno());
				followUpService.addFollowUp(followUp);
			}
			else
			{
				followUpService.deleteFollowUp(inquery.getPhoneno());
			}
			attributes.addFlashAttribute("success", "Inquery Added Successfully...");
		} 
		catch (Exception e) 
		{
			attributes.addFlashAttribute("error", "Failed to add Inquery..."+e.getMessage());
		}
		return "redirect:/employee/inquery";
	}
	
	
	
}
