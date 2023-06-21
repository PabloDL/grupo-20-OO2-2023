package com.UNLa.services;

import java.util.List;

import com.UNLa.entities.Student;

public interface StudentService {
	List<Student> getAllStudents();

	Student saveStudent(Student student);
}
