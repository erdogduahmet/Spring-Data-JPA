package com.ahmeterdogdu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ahmeterdogdu.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	//buraya kendi özel metotlarımızı yazacağız ileride
	
	//HQL: sınıfın ismi ve değişken isimleri kullanılarak sorgular yazılır
	@Query(value = "from Student", nativeQuery = false)
	List<Student> findAllStudents();
	
	//SQL: tablo ismi ve tablo içerisindeki kolon isimleri ile sorgular yazılır.
	//@Query(value = "select * from student.student", nativeQuery = true)
	//List<Student> findAllStudents();
	
	@Query(value = "from Student s WHERE s.id= :studentId")
	Optional<Student> findStudentById(Integer studentId);

}
