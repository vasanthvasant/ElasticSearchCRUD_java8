package com.elasticSearch.crud.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.elasticSearch.crud.entity.Student;
import com.elasticSearch.crud.repositiry.StudentRepository;
@Service
public class StudentService {
	@Autowired(required = true)
	private StudentRepository studentRepository;
	
	public Iterable<Student> getAllStudent(){
		return  studentRepository.findAll();
				
	}
	
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	public Student getStudent(int id) {
		return studentRepository.findById(id).get();
	}
	
	public Student updateStudent(Student student, int id) {
//		Student std = studentRepository.findById(id).get();
//		std.setId(student.getId());
//		std.setEmail(student.getEmail());
//		std.setName(student.getName());
//		std.setMobile(student.getMobile());
//		return studentRepository.save(std);
		return studentRepository.save(student);
		}
	
	public String deletStudent( int id) {
		studentRepository.deleteById(id);
		return "student delete";
	}

}
