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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.entities.Course;
import com.example.service.CourseService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class CourseController 
{
	@Autowired
	CourseService courseService;
	
	/*
	@GetMapping("/course-management")
	public String courseManagement(Model model)
	{
		model.addAttribute("courses", courseService.getAllCourses());
		return "admin/pages/course-management";
	}
	*/
	
	@GetMapping("/course-management")
	public String courseManagement(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "4") int size , HttpSession session, RedirectAttributes attributes)
	{
		
		if(session.getAttribute("admin")==null)
		{
			attributes.addFlashAttribute("error", "Login First Access");
			return "redirect:/admin/login";
		}
		
		Pageable pageable = PageRequest.of(page, size);
		
		Page<Course> courses = courseService.getCoursesByPagination(pageable);
		
		model.addAttribute("courses", courses);
		return "admin/pages/course-management";
	}
	
	@GetMapping("/addCourse")
	public String addCourse(Model model, HttpSession session, RedirectAttributes attributes)
	{
		if(session.getAttribute("admin")==null)
		{
			attributes.addFlashAttribute("error", "Login First Access");
			return "redirect:/admin/login";
		}
		
		model.addAttribute("course", new Course());
		return "admin/pages/addCourse";
	}
	
	@PostMapping("/addCourse")
	public String handleAddCourse(@ModelAttribute("course") Course course, @RequestParam("courseImage") MultipartFile image, RedirectAttributes attributes, HttpSession session)
	{
		if(session.getAttribute("admin")==null)
		{
			attributes.addFlashAttribute("error", "Login First Access");
			return "redirect:/admin/login";
		}
		
		try {
			courseService.addCourse(course, image);
			attributes.addFlashAttribute("success", "Course Added Succesfully...");
		} 
		catch (Exception e) 
		{
			attributes.addFlashAttribute("error", "Course Adding Failed...");
		}
		return "redirect:/admin/addCourse";
	}
	
	@GetMapping("/editCourse")
	public ModelAndView editCourseForm(@RequestParam("name") String name, RedirectAttributes attributes, HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("admin")==null)
		{
			attributes.addFlashAttribute("error", "Login First Access");
			mv.setViewName("redirect:/admin/login");
			return mv;
		}
		
		
		if(name==null || name.equals(""))
		{
			mv.setViewName("redirect:/admin/course-management");
			return mv;
		}

		Course course = courseService.getCourseByName(name);
		mv.addObject("course", course);
		mv.setViewName("/admin/pages/editCourse");
		
		return mv;
	}
	
	@PostMapping("/editCourse")
	public ModelAndView editCourse(@ModelAttribute("course") Course course, @RequestParam("courseImage") MultipartFile image , RedirectAttributes attributes, HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("admin")==null)
		{
			attributes.addFlashAttribute("error", "Login First Access");
			mv.setViewName("redirect:/admin/login");
			return mv;
		}
		try 
		{
			courseService.editCourse(course, image);
			mv.addObject("success", "Course Updated Succesfully...");
			mv.addObject("course", courseService.getCourseByName(course.getName()));
		} 
		catch (Exception e) 
		{
			mv.addObject("error", "Course Updation Failed...");
			mv.addObject("course", courseService.getCourseByName(course.getName()));
		}
		mv.setViewName("/admin/pages/editCourse");
		return mv;
	}
	
	@GetMapping("/deleteCourse")
	public ModelAndView deleteCourse(@RequestParam("name") String name, RedirectAttributes attributes, HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("admin")==null)
		{
			attributes.addFlashAttribute("error", "Login First Access");
			mv.setViewName("redirect:/admin/login");
			return mv;
		}
		mv.setViewName("redirect:/admin/course-management");
		if(name!=null && !name.equals(""))
		{
			try 
			{
				courseService.deleteCourse(name);
				attributes.addFlashAttribute("success", "Course deleted Succesfully...");
			} 
			catch (Exception e) 
			{
				attributes.addFlashAttribute("error", "Course deletion Failed... "+e);
			}
			
		}
		
		return mv;
	}
}
