package com.elasticSearch.crud.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.elasticSearch.crud.entity.Student;
import com.elasticSearch.crud.service.StudentService;

@RestController
@RequestMapping("/api/v1")
public class StuentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private Validate validate;
	Message fileNotFoune =new  Message("005","File not Found");
	Message emailMessage = new Message("003","invalid email");
	Message mobileMessage = new Message("002","invalid Mobile number");
	Message snameMessage = new Message("001","number not allowed in name");
	@PostMapping("/student")
	public Object saveStuent(@RequestBody Student student) {
		if(!validate.validMail(student.getEmail())) {
			 return emailMessage;
		}
		else if(!validate.validateMobile(student.getMobile())) {
			return mobileMessage;
		}
		else if(validate.validateSname(student.getName())) {
			return snameMessage;
		}
		else {
			
			return studentService.saveStudent(student);
		}
		
	}
	
	@GetMapping("/student/showall")
	public Iterable<Student> findAll(){
		return studentService.getAllStudent();
	}
	
	@GetMapping("/student/{id}")
	public Object getStudent(@PathVariable int id)  {
		if(validate.validateId(id)) {
			   return fileNotFoune;
		}
		else {
			 return studentService.getStudent(id);
		}
	}
	@PutMapping("/student/{id}")
	public Object updateStudent(@RequestBody Student student,@PathVariable int id) {
	if(validate.validateId(id)) {
		if(!validate.validMail(student.getEmail())) {
			 return emailMessage;
		}
		else if(!validate.validateMobile(student.getMobile())) {
			return mobileMessage;
		}
		else if(validate.validateSname(student.getName())) {
			return snameMessage;
		}
		else {
			
			return studentService.saveStudent(student);
		}
	}
	else {
		return fileNotFoune;
	}
	}
	@DeleteMapping("/student/{id}")
	public Object deleteStuent(@PathVariable int id) {
		if(validate.validateId(id)) {
			 return fileNotFoune;
		}
		else {
			return studentService.deletStudent(id);
		}
		
	}

}
