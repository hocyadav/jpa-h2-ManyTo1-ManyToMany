package com.example.demo.api;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.DeptDAO;
import com.example.demo.dao.EmpDAO;
import com.example.demo.model.Department;
import com.example.demo.model.Employee;

@RestController
@RequestMapping("/emp")
public class Apis {
	
	@Autowired
	EmpDAO empDAO;
	
	@Autowired
	DeptDAO deptDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> getAllEmp() {
		return empDAO.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void saveEmp(@RequestBody Employee employee) {
		empDAO.save(employee);
	}
	
	@RequestMapping(value = "/dep", method = RequestMethod.GET)
	public List<Department> getAllDept() {
		return deptDAO.findAll();
	}
	
	@RequestMapping(value = "/dep", method = RequestMethod.POST)
	public void saveDept(@RequestBody Department department) {
		List<Employee> list = new LinkedList();
		
		Employee e = new Employee();
		e.setEname("hariom yadav");
		empDAO.save(e);
		list.add(e);
		
		Employee e2 = new Employee();
		e2.setEname("chandan yadav");
		empDAO.save(e2);
		list.add(e2);

		department.setEmp(list);
		
		deptDAO.save(department);
	}
	
}
