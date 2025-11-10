package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.dto.OrderedCourse;
import com.example.entities.User;
import com.example.service.CourseService;
import com.example.service.OrderService;
import com.example.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController 
{

    
	@Autowired
	UserService service;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	OrderService orderService;
	
    @GetMapping({"/","/index"})
    public ModelAndView index(HttpSession session)
    {
    	ModelAndView mv = new ModelAndView();
    	User user = (User) session.getAttribute("sessionUser");
    	if(user!=null)
    	{
    		mv.addObject("sessionUser", user);
    		mv.addObject("purchasedList", orderService.getPurchasedNamesByEmail(user.getEmail()));
    	}
    	
    	
    	mv.addObject("courses", courseService.getAllCourses());
    	mv.setViewName("index");
    	return mv;
    }
    
	@GetMapping("/register")
	public ModelAndView showRegister(HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("sessionUser")!=null)
		{
			mv.setViewName("redirect:/profile");
		}
		else
		{
			mv.addObject("user", new User());
			mv.setViewName("customer/register");
		}
		return mv;
	}
	
	@PostMapping("/register")
	public String handleRegister(@Valid @ModelAttribute("user") User user, BindingResult bindingResult , RedirectAttributes attributes)
	{
		if(bindingResult.hasErrors())
		{
			return "customer/register";
		}
		
		if(service.findUserByEmail(user.getEmail()) != null)
		{
			bindingResult.rejectValue("email", "error.user", "Email Already Registered...");
			return "customer/register";
		}
		if(service.findUserByPhone(user.getPhoneno()) != null)
		{
			bindingResult.rejectValue("phoneno", "error.user", "Phone No. Already Registered...");
			return "customer/register";
		}
		
			
		if(service.registerUser(user))
		{
			attributes.addFlashAttribute("success", "User Register Successfully...");
		}
		else
		{
			attributes.addFlashAttribute("error","User Registeration Failed...");
		}
			
		return "redirect:/register";
		
	}
	
	
	
	@GetMapping("/login")
	public ModelAndView showLogin(HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		
		if( session.getAttribute("sessionUser") != null )
		{
			mv.setViewName("redirect:/profile");
		}
		else
		{
			mv.addObject("user", new User());
			mv.setViewName("customer/login");
		}
		return mv;
	}
	
	@PostMapping("/login")
	public String handleLogin(@ModelAttribute("user") User user,HttpSession session, Model model)
	{
		user = service.authenticate(user.getEmail(), user.getPassword());
		if(user != null)
		{
			if(user.getBanStatus())
			{
				model.addAttribute("error", "Your account has blocked please contact admin...!");
				return "customer/login";
			}
			session.setAttribute("sessionUser", user);
			return "redirect:/profile";
		}
		else
		{
			model.addAttribute("error", "Invalid email or password. Please try again.");
			return "customer/login";
		}
	}
	
	@GetMapping("/profile")
	public ModelAndView profile(HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		
		User sessionUser = (User) session.getAttribute("sessionUser");
		
		if(sessionUser == null)
		{
			mv.setViewName("redirect:/login");
		}
		else
		{
			mv.addObject("sessionUser", sessionUser);
			mv.setViewName("customer/profile");
		}
		return mv;
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "customer/login";
	}
	
	@GetMapping("/mycourses")
	public ModelAndView myCourses(HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		
		User sessionUser = (User) session.getAttribute("sessionUser");
		
		if(sessionUser == null)
		{
			mv.setViewName("redirect:/login");
		}
		else
		{
			List<OrderedCourse> orderedCourses = orderService.getOrderedCourses(sessionUser.getEmail());
			mv.addObject("orderedCourses", orderedCourses);
			mv.addObject("sessionUser", sessionUser);
			mv.setViewName("customer/enrollments");
		}
		
		return mv;
	}
}
