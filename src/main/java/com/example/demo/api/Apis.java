package com.example.demo.api;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.StudentDAO;
import com.example.demo.dao.SubjectDAO;
import com.example.demo.model.Student;
import com.example.demo.model.Subject;

@RestController
@RequestMapping("/st")
public class Apis {

	@Autowired
	StudentDAO studentDAO;
	
	@Autowired
	SubjectDAO subjectDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Student> getAll() {
		return studentDAO.findAll();
	}
	
	//working - add empty list - by default
//	@RequestMapping(method = RequestMethod.POST)
//	public void saveStudent(@RequestBody Student student) {
//		studentDAO.save(student);
//	}
	
	//working -we are creating -> adding into db - adding into list -> then adding into curent new objct
	@RequestMapping(method = RequestMethod.POST)
	public void saveStudent(@RequestBody Student student) {
		Random r = new Random();
		List<Subject> list = new LinkedList<Subject>();
		
		Subject s = new Subject();
		s.setName("physics"+r.nextInt());
		subjectDAO.save(s);
		list.add(s);
		
		Subject s2 = new Subject();
		s2.setName("physics"+r.nextInt());
		subjectDAO.save(s2);
		list.add(s2);
		
		student.setSub_list(list);
		studentDAO.save(student);
	}

	
	@RequestMapping(value = "/su", method = RequestMethod.GET)
	public List<Subject> getAllSubh() {
		return subjectDAO.findAll();
	}
	
	@RequestMapping(value = "/su", method = RequestMethod.POST)
	public void saveSubj(@RequestBody Subject subject) {
		subjectDAO.save(subject);
	}
	
}
