package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Inquery;
import com.example.service.InqueryService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/employee/api")
public class InqueryApi 
{
	@Autowired
	InqueryService inqueryService;
	
	@GetMapping("/searchInqueries")
	public List<Inquery> searchInqueries(@RequestParam("phoneno") String phoneno,HttpSession session)
	{
		if(session.getAttribute("employee")!=null)
		{
			return inqueryService.findByNumber(phoneno);
			
		}
		return null;
	}
}
