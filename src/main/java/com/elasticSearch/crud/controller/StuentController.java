package com.elasticSearch.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elasticSearch.crud.entity.Student;
import com.elasticSearch.crud.service.StudentService;

@RestController
@RequestMapping("/api/v1")
public class StuentController {
	@Autowired
	private StudentService studentService;
	@PostMapping("/student")
	public Student saveStuent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@GetMapping("/student/showall")
	public Iterable<Student> findAll(){
		return studentService.getAllStudent();
	}
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable int id) {
		return studentService.getStudent(id);
	}
	@PutMapping("/student/{id}")
	public Student updateStudent(@PathVariable Student student, int id) {
		return studentService.updateStudent(student, id);
	}
	@DeleteMapping("/student/{id}")
	public String deletStuent(@PathVariable int id) {
		return studentService.deletStudent(id);
	}

}
