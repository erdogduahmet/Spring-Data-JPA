package com.ahmeterdogdu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahmeterdogdu.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	//buraya kendi özel metotlarımızı yazacağız ileride

}
