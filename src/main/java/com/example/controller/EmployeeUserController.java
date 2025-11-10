package com.example.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.entities.Employee;
import com.example.entities.Orders;
import com.example.repositories.UserRepository;
import com.example.service.CourseService;
import com.example.service.EmployeeService;
import com.example.service.OrderService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/employee")
public class EmployeeUserController 
{
	@Autowired
	EmployeeService service;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	OrderService orderService;

	@GetMapping("/login")
	public String loginForm(HttpSession session)
	{
		Employee employee =  (Employee) session.getAttribute("employee");
		if(employee!=null)
		{
			return "redirect:/employee/dashboard";
		}
		return "employee/login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session, RedirectAttributes attributes)
	{
		Employee employee = service.validateEmployee(email, password);
		if(employee!=null)
		{
			session.setAttribute("employee", employee);
			return "redirect:/employee/dashboard";
		}
		else
		{
			attributes.addFlashAttribute("error", "Invalid Credentials");
			return "redirect:/employee/login";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:/employee/login";
	}
	
	@GetMapping("/register")
	public String registerForm(Model model, HttpSession session)
	{
		Employee employee =  (Employee) session.getAttribute("employee");
		if(employee!=null)
		{
			return "redirect:/employee/dashboard";
		}
		model.addAttribute("employee", new Employee());
		return "employee/register";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute("employee") Employee employee, RedirectAttributes attributes)
	{
		try 
		{
			service.addEmployee(employee);
			attributes.addFlashAttribute("success","Employee Registered Successfully...");
		} 
		catch (Exception e) 
		{
			attributes.addFlashAttribute("error",e.getMessage());
		
		}
		
		return "redirect:/employee/register";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session)
	{
		Employee employee = (Employee) session.getAttribute("employee");
		
		if(employee!=null)
		{
			model.addAttribute("employee", employee);
			return "employee/dashboard";
		}
		return "redirect:/employee/login";
	}
	
	@GetMapping("/sellCourse")
	public String sellCourseForm(Model model, HttpSession session)
	{
		Employee employee = (Employee) session.getAttribute("employee");
		if(employee!=null)
		{
			Orders order = new Orders();
			order.setOrderId(UUID.randomUUID().toString());
			order.setEmployeeEmail(employee.getEmail());
			
			model.addAttribute("courseNames", courseService.getCourseNames());
			model.addAttribute("employee", employee);
			model.addAttribute("order", order);
			return "/employee/sellCourse";
		}
		else
		{
			return "redirect:/employee/login";
		}
	}
	@PostMapping("/sellCourse")
	public String sellCourse(@ModelAttribute("order")Orders order, RedirectAttributes attributes)
	{
		orderService.createUserOrder(order);
		attributes.addFlashAttribute("success", "Course Sold Succesfully...");
		return "redirect:/employee/sellCourse";
	}
	
	// API for AJAX to get price dynamically
	@GetMapping("/course/price")
	@ResponseBody
	public String getCoursePrice(@RequestParam("name")String name)
	{
		return courseService.getCoursePriceByName(name);
	}
	
	@GetMapping("/followUps")
	public String followUps(Model model, HttpSession session)
	{
		Employee employee = (Employee) session.getAttribute("employee");
		if(employee!=null)
		{
			model.addAttribute("employee", employee);
			model.addAttribute("courseNames", courseService.getCourseNames());
			return "/employee/followUps";
		}
		return "redirect:/employee/login";
	}
	
}
