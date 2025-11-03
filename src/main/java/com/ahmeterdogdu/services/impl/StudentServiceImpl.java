package com.ahmeterdogdu.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmeterdogdu.dto.DtoLesson;
import com.ahmeterdogdu.dto.DtoStudent;
import com.ahmeterdogdu.dto.DtoStudentIU;
import com.ahmeterdogdu.entities.Lesson;
import com.ahmeterdogdu.entities.Student;
import com.ahmeterdogdu.repository.StudentRepository;
import com.ahmeterdogdu.services.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
		DtoStudent response=new DtoStudent();
		Student student= new Student();
		BeanUtils.copyProperties(dtoStudentIU, student);
		
		Student dbStudent=studentRepository.save(student);
		BeanUtils.copyProperties(dbStudent, response);
		return response;
	}

	@Override
	public List<DtoStudent> getAllStudents() {
		List<DtoStudent> dtoList=new ArrayList<>();
		List<Student> studentList= studentRepository.findAllStudents();
		
		for (Student student : studentList) {
			DtoStudent dtoStudent=new DtoStudent();
			BeanUtils.copyProperties(student, dtoStudent);
			dtoList.add(dtoStudent);
		}
		
		return dtoList;
	}

	@Override
	public DtoStudent getStudentById(Integer id) {
		DtoStudent dtoStudent=new DtoStudent();
		
		Optional<Student> optional =studentRepository.findStudentById(id);
		if (optional.isEmpty()) {
			return null;
		}
		
		Student dbStudent=optional.get();
		BeanUtils.copyProperties(dbStudent, dtoStudent);
		
		if (dbStudent.getLessons()!=null && !dbStudent.getLessons().isEmpty()) {
			for (Lesson lesson: dbStudent.getLessons()) {
				DtoLesson dtoLesson=new DtoLesson();
				BeanUtils.copyProperties(lesson, dtoLesson);
				
				dtoStudent.getLessons().add(dtoLesson);
			}
		}
		return dtoStudent;		
		
	}

	@Override
	public void deleteStudent(Integer id) {
		Optional<Student> optional= studentRepository.findById(id);
		if (optional.isPresent()) {
			studentRepository.delete(optional.get());
		}
	}

	@Override
	public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU) {
		DtoStudent dtoStudent=new DtoStudent();
		
		Optional<Student> optional= studentRepository.findById(id);
		if (optional.isPresent()) {
			Student dbStudent=optional.get();
			
			dbStudent.setFirstName(dtoStudentIU.getFirstName());
			dbStudent.setLastName(dtoStudentIU.getLastName());
			dbStudent.setBirthOfDate(dtoStudentIU.getBirthOfDate());
			
			Student updatedStudent=studentRepository.save(dbStudent);
			
			BeanUtils.copyProperties(updatedStudent, dtoStudent);
			return dtoStudent;
		}
		return null;
	}
}
