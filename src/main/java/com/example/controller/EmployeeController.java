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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.entities.Employee;
import com.example.service.CourseService;
import com.example.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class EmployeeController {

    private final CourseService courseService;

	@Autowired
	EmployeeService employeeService;

    EmployeeController(CourseService courseService) {
        this.courseService = courseService;
    }
	
	@GetMapping("/employee-management")
	public String employeeManagement(Model model, @RequestParam(name="page", defaultValue = "0") int page,
			@RequestParam(name="size", defaultValue = "5") int size, RedirectAttributes attributes, HttpSession session)
	{
		if(session.getAttribute("admin")==null)
		{
			attributes.addFlashAttribute("error", "Login First to Access Admin Dashboard");
			return "redirect:/admin/login";
		}
		
		Pageable pageable = PageRequest.of(page, size);
		Page<Employee> employees = employeeService.getEmployeesByPagination(pageable);
		
		model.addAttribute("employees", employees);
		
		return "admin/pages/employee-management";
	}
	
	@GetMapping("/addEmployee")
	public String addEmployeeForm(Model model, RedirectAttributes attributes, HttpSession session)
	{
		if(session.getAttribute("admin")==null)
		{
			attributes.addFlashAttribute("error", "Login First to Access Admin Dashboard");
			return "redirect:/admin/login";
		}
		model.addAttribute("employee", new Employee());
		return "/admin/pages/addEmployee";
	}
	
	@PostMapping("/addEmployee")
	public ModelAndView addEmployee(@ModelAttribute("employee") Employee employee, RedirectAttributes attributes, HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		
		if(session.getAttribute("admin")==null)
		{
			attributes.addFlashAttribute("error", "Login First to Access Admin Dashboard");
			mv.setViewName("redirect:/admin/login");
			return mv;
		}
		
		try 
		{
			employeeService.addEmployee(employee);
			attributes.addFlashAttribute("success","Employee Added Succesfully...");
		} 
		catch (Exception e) 
		{
			attributes.addFlashAttribute("error","Employee Already exists...");
		}
		mv.setViewName("redirect:/admin/addEmployee");
		
		return mv;
	}
	
	@GetMapping("/editEmployee")
	public String editEmployeeForm(@RequestParam("email") String email ,Model model, RedirectAttributes attributes, HttpSession session)
	{
		if(session.getAttribute("admin")==null)
		{
			attributes.addFlashAttribute("error", "Login First to Access Admin Dashboard");
			return "redirect:/admin/login";
		}
		Employee employee = employeeService.getEmployeeByEmail(email);
		if(employee!=null)
		{
			model.addAttribute("employee", employee);
			return "/admin/pages/editEmployee";
		}
		else
		{
			attributes.addFlashAttribute("error", "Nice Try....");
			return "redirect:/admin/employee-management";
		}
	}
	
	@PostMapping("/editEmployee")
	public String editEmployee(@ModelAttribute("employee") Employee employee, RedirectAttributes attributes, HttpSession session)
	{
		if(session.getAttribute("admin")==null)
		{
			attributes.addFlashAttribute("error", "Login First to Access Admin Dashboard");
			return "redirect:/admin/login";
		}
		try 
		{
			employeeService.editEmployee(employee);
			attributes.addFlashAttribute("success","Employee Updated Succesfully...");
		} 
		catch (Exception e) 
		{
			attributes.addFlashAttribute("error ",e.getMessage());
		}
		
		return "redirect:/admin/editEmployee?email="+employee.getEmail();
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("email") String email, RedirectAttributes attributes, HttpSession session)
	{
		if(session.getAttribute("admin")==null)
		{
			attributes.addFlashAttribute("error", "Login First to Access Admin Dashboard");
			return "redirect:/admin/login";
		}
		
		if(email!=null && !email.equals(""))
		{
			if(employeeService.deleteEmployee(email))
			{
				attributes.addFlashAttribute("success","Employee Updated Succesfully...");
			}
			else
			{
				attributes.addFlashAttribute("Employee Delation Failed ");
			} 	
		}
		return "redirect:/admin/employee-management";
	}

}
