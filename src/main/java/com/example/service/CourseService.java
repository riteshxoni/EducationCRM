package com.example.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.entities.Course;
import com.example.repositories.CourseRepository;

@Service
public class CourseService {
	
	final String IMAGE_PATH = "src/main/resources/static/images/";
	final String OLD_IMAGE_PATH = "src/main/resources/static/";
	
	@Autowired
	private CourseRepository repository;
	
	public List<Course> getAllCourses()
	{
		return repository.findAll();
	}
	
	public Page<Course> getCoursesByPagination(Pageable pageable)
	{
		return repository.findAll(pageable);
	}
	
	public void addCourse(Course course, MultipartFile image) throws IOException
	{
		String imageName = image.getOriginalFilename();
		
		Path path =  Paths.get(IMAGE_PATH + imageName);
		Files.write(path, image.getBytes());
		
		course.setImageUrl("/images/"+imageName);
		
		repository.save(course);
	}
	
	public Course getCourseByName(String name)
	{
		return repository.findByName(name);
	}
	
	public void editCourse(Course course,MultipartFile image) throws IOException
	{
		if(!image.isEmpty())
		{
			String imageName = image.getOriginalFilename();
			Path path = Paths.get(IMAGE_PATH+imageName);
			Files.write(path, image.getBytes());
			
			path = Paths.get(OLD_IMAGE_PATH+course.getImageUrl());
			Files.deleteIfExists(path);
			
			course.setImageUrl("images/"+imageName);
		}
		repository.save(course);
	}
	
	public void deleteCourse(String name) throws IOException
	{
		Course course = repository.findByName(name);
		if(course!=null)
		{
			Path path = Paths.get(OLD_IMAGE_PATH+course.getImageUrl());
			Files.deleteIfExists(path);
			repository.delete(course);
		}
		else
		{
			throw new RuntimeException("Course not found exception!...");
		}
	}
	
	public List<String> getCourseNames()
	{
		List<Course> list = repository.findAll();
		
		List<String> names = new ArrayList<>();
		
		for(Course course : list)
		{
			names.add(course.getName());
		}
		
		return names;
	}
	
	public String getCoursePriceByName(String courseName)
	{
		Course course = repository.findByName(courseName);
		if(course!=null)
		{
			return course.getDiscountedPrice();
		}
		return null;
	}
	
}
