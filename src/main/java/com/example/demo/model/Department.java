package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Department {
	@Id @GeneratedValue
	private int did;
	private String dName;
	@OneToMany
	private List<Employee> emp;
}
