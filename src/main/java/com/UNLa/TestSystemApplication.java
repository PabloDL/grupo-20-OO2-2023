package com.UNLa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.UNLa.entity.Student;
import com.UNLa.repository.StudentRepository;

@SpringBootApplication
public class TestSystemApplication { //implements CommandLineRunner{
	
//	@Autowired
//	private StudentRepository studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TestSystemApplication.class, args);
	}

//	@Override
//	public void run(String... args ) throws Exception {
//		Student student1 = new Student("pablo", "De Laforé", "pablo.delafore@hotmail.com");
//		studentRepository.save(student1);
//		
//		Student student2 = new Student("ramesh", "fadatare", "ramesh@gmail.com");
//		studentRepository.save(student2);
//
//		Student student3 = new Student("tony", "stark", "Stark@gmail.com");
//		studentRepository.save(student3);
//	}
	
}