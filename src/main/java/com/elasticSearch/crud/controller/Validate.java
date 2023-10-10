package com.elasticSearch.crud.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.elasticSearch.crud.service.StudentService;
@Component
public class Validate {
	@Autowired
	private StudentService studentService;
	
	public boolean validMail(String mail) {
		String str = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(str);
		Matcher matcher = pattern.matcher(mail);
		return matcher.matches();
	}
	
	public boolean validateMobile(long mobile) {
		String mobile1 =mobile+"";
		return mobile1.matches("\\d{10}");
	}
	public boolean validateSname(String sname) {
		return sname.matches(".*\\d.*");
	}
	public boolean validateId(int id) {
		try{
			studentService.getStudent(id);
		return false;
		}
		catch (Exception e){return true; }
	}

}
