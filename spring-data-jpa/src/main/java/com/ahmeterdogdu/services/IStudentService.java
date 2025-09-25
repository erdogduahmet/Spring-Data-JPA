package com.ahmeterdogdu.services;

import java.util.List;

import com.ahmeterdogdu.dto.DtoStudent;
import com.ahmeterdogdu.dto.DtoStudentIU;

public interface IStudentService {
	
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);
	
	public List<DtoStudent> getAllStudents();
	
	public DtoStudent getStudentById(Integer id);
	
	public void deleteStudent(Integer id);
	
	public DtoStudent updateStudent(Integer id,DtoStudentIU dtoStudentIU);
}
