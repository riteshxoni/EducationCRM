package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.entities.Admin;
import com.example.entities.Course;
import com.example.service.AdminService;
import com.example.service.CourseService;
import com.example.service.OrdersChartsService;
import com.example.service.SalesService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController 
{
	@Autowired
	CourseService courseService;
	
	@Autowired
	SalesService salesService;
	
	@Autowired
	OrdersChartsService chartsService;
	
	@Autowired
	AdminService adminService;
	
	
	
	@GetMapping("/dashboard")
	public String dashboard(Model model,HttpSession session, RedirectAttributes attributes)
	{
		
		if(session.getAttribute("admin")==null)
		{
			attributes.addFlashAttribute("error", "Login First to Access Admin Dashboard");
			return "redirect:/admin/login";
		}
		
		
		List<Object[]> list = chartsService.getSalesPerDate();
		
		List<String> dates = new ArrayList<>();
		List<Long> sales = new ArrayList<>();
		
		for(Object[] obj : list)
		{
			dates.add((String)obj[0]);
			sales.add((Long) obj[1]);
		}
		
		model.addAttribute("dates", dates);
		model.addAttribute("sales", sales);
		
		
		List<Object[]> nameAndSales = chartsService.findCourseWithSales();
		List<String> courseNames = new ArrayList<>();
		List<Long> courseSales = new ArrayList<>();
		
		for(Object[] obj : nameAndSales )
		{
			courseNames.add((String)obj[0]);
			courseSales.add((Long)obj[1]);
		}
		
		model.addAttribute("courseNames", courseNames);
		model.addAttribute("courseSales", courseSales);
		
		List<Object[]> dateAmountOfSales = chartsService.findDateAmountOfSales();
		List<String> salesDate = new ArrayList<>();
		List<Double> salesAmount = new ArrayList<>();
		
		for(Object[] obj : dateAmountOfSales)
		{
			salesDate.add((String)obj[0]);
			salesAmount.add((Double)obj[1]);
		}
		
		model.addAttribute("salesDate", salesDate);
		model.addAttribute("salesAmount", salesAmount);
		
		return "admin/pages/admin-dashboard";
	}
	
	
	@GetMapping("/sales")
	public String sales(Model model, HttpSession session, RedirectAttributes attributes)
	{
		if(session.getAttribute("admin")==null)
		{
			attributes.addFlashAttribute("error", "Login First to Access Admin Dashboard");
			return "redirect:/admin/login";
		}
		model.addAttribute("totalSales", salesService.getTotalSalesAmount());
		model.addAttribute("totalSalesByEmployee", salesService.getTotalEmployeeSalesAmount());
		model.addAttribute("empWithTotalSales", salesService.findEachEmployeeWithTotalSales());
		return "admin/pages/sales";
	}
	
	@GetMapping("/settings")
	public String settings(Model model, HttpSession session, RedirectAttributes attributes)
	{
		if(session.getAttribute("admin")==null)
		{
			attributes.addFlashAttribute("error", "Login First to Access Admin Dashboard");
			return "redirect:/admin/login";
		}
		model.addAttribute("admin", session.getAttribute("admin"));
		return "admin/pages/settings";
	}
	
	@GetMapping("/login")
	public String loginForm()
	{
		return "/admin/pages/admin-login";
	}
	
	@PostMapping("/login")
	public String handlelogin(@RequestParam("email") String email, @RequestParam("password") String password,HttpSession session, RedirectAttributes attributes,Model model)
	{
		Admin admin = adminService.authentication(email, password);
		if(admin!=null)
		{
			session.setAttribute("admin", admin);
			return "redirect:/admin/dashboard";
		}
		else
		{
			attributes.addFlashAttribute("error", "Invalid Credintials...!");
			return "redirect:/admin/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "admin/pages/admin-login";
	}
	
	@GetMapping("/changePassword")
	public String changePassForm(HttpSession session, RedirectAttributes attributes)
	{
		if (session.getAttribute("admin")==null) 
		{
			attributes.addFlashAttribute("error", "Login First...!");
			return "redirect:/admin/login";
		}
		return "/admin/pages/changePassword";
	}
	
	@PostMapping("/changePassword")
	public String changePassword(@RequestParam("password") String pass,
								 @RequestParam("newPass") String pass1,
								 @RequestParam("confirmNewPass") String pass2,
								 HttpSession session,
								 RedirectAttributes attributes
								)
	{
		Admin admin =  (Admin) session.getAttribute("admin");
		if(admin==null)
		{
			attributes.addFlashAttribute("error", "Login First...!");
			return "redirect:/admin/login";
		}
		
		if(admin.getPassword().equals(pass))
		{
			if(pass1.equals(pass2))
			{
				admin.setPassword(pass1);
				adminService.updatePassword(admin);
				attributes.addFlashAttribute("success", "Password Changed Successfully...");
			}
			else
			{
				attributes.addFlashAttribute("error", "New Password didn't matched...");
			}
		}
		else
		{
			attributes.addFlashAttribute("error", "Old Password didn't matched...");
		}
		
		return "redirect:/admin/changePassword";
	}
}
