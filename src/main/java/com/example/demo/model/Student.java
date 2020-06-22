package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor @Getter @Setter
public class Student {
	@Id @GeneratedValue
	private int sid;
	private String name;
	
	//working - this will create new column in student with subject PK as value
//	@ManyToOne
//	private Subject subject;
	
	//working - this will create new table - Student and Subject PK as values
	@ManyToMany
	private List<Subject> sub_list;

	public Student(String name) {
		this.name = name;
	}
}	
