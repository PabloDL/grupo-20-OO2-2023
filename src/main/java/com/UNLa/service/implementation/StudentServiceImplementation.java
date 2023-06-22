package com.UNLa.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.UNLa.entity.Student;
import com.UNLa.repository.StudentRepository;
import com.UNLa.service.StudentService;

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
	
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	};

}
