package com.UNLa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UNLa.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
}
