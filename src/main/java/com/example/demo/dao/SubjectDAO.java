package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Subject;

@Repository
public interface SubjectDAO extends JpaRepository<Subject, Integer>{

}
