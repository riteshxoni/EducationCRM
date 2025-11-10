package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Employee;
import com.example.entities.FollowUps;
import com.example.service.FollowUpService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/employee/api")
public class FollowUpApi {
	
	@Autowired
	FollowUpService followUpService;
	
	@GetMapping("getFollowUps")
	public ResponseEntity<List<FollowUps>> getFollowUps(@RequestParam("followUpsdate") String followUpsdate, HttpSession session)
	{
		Employee employee = (Employee) session.getAttribute("employee");
		if(employee!=null)
		{
			List<FollowUps> list =  followUpService.getByDateAndEmpEmail(followUpsdate, employee.getEmail());
			return ResponseEntity.ok(list);
		}
		return ResponseEntity.ok(null);
	}
}
