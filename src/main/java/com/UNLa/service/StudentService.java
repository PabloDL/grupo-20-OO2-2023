package com.UNLa.service;

import java.util.List;

import com.UNLa.entity.Student;

public interface StudentService {
	List<Student> getAllStudents();

	Student saveStudent(Student student);
}
