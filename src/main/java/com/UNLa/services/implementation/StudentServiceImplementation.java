package com.UNLa.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.UNLa.entities.Student;
import com.UNLa.repositories.StudentRepository;
import com.UNLa.services.StudentService;

@Service
public class StudentServiceImplementation implements StudentService {
	
	private StudentRepository studentRepository;
		
	 public StudentServiceImplementation(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {		
		return studentRepository.findAll();
	}
	
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	};

}
