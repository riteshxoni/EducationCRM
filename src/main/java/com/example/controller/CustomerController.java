package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.entities.Orders;
import com.example.entities.User;
import com.example.service.OrderService;
import com.example.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class CustomerController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/customer-management")
	public String customerManagement(
			@RequestParam(name = "page", defaultValue = "0")int page
			,@RequestParam(name = "size", defaultValue = "5") int size ,Model model, HttpSession session, RedirectAttributes attributes)
	{
		if(session.getAttribute("admin")==null)
		{
			attributes.addFlashAttribute("error", "Login First to Access Admin Dashboard");
			return "redirect:/admin/login";
		}
		
		Pageable pageable = PageRequest.of(page, size);
		Page<User> users = userService.getAllUsers(pageable);
		model.addAttribute("customers", users);
		
		return "admin/pages/customer-management";
	}
	
	@GetMapping("/status")
	public String banUser(@RequestParam("id")int id, @RequestParam("status") boolean status)
	{
		User user =  userService.findUserById(id);
		if(user!=null)
		{
			user.setBanStatus(status);
			userService.updateUser(user);
		}
		return "redirect:/admin/customer-management";
	}
	
	@GetMapping("/showUser")
	public String showUserInfo(@RequestParam("id") int id, HttpSession session, RedirectAttributes attributes, Model model)
	{
		if(session.getAttribute("admin")==null)
		{
			attributes.addFlashAttribute("error", "Login First");
			return "redirect:/admin/login";
		}
		
		User user = userService.findUserById(id);
		if(user!=null)
		{
			List<Orders> orderedCourse = orderService.findCoursesByEmail(user.getEmail());
			model.addAttribute("user", user);
			model.addAttribute("userOrders", orderedCourse);
		}
		return "/admin/pages/showUser";
	}
	
}
