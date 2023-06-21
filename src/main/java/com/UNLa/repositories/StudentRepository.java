package com.UNLa.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.UNLa.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
}
