package com.ahmeterdogdu.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmeterdogdu.dto.DtoDepartment;
import com.ahmeterdogdu.dto.DtoEmployee;
import com.ahmeterdogdu.entities.Employee;
import com.ahmeterdogdu.repository.EmployeeRepository;
import com.ahmeterdogdu.services.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<DtoEmployee> findAllEmployees() {
		List<DtoEmployee> dtoEmployeeList=new ArrayList<>();
		
		List<Employee> employeeList =employeeRepository.findAll();
		if (employeeList!=null && !employeeList.isEmpty()) {
			for (Employee employee : employeeList) {
				DtoEmployee dtoEmployee=new DtoEmployee();
				BeanUtils.copyProperties(employee, dtoEmployee);
				
				dtoEmployee.setDepartment(new DtoDepartment(employee.getDepartment().getId(), 
						employee.getDepartment().getDepartmentName()));
				
				dtoEmployeeList.add(dtoEmployee);
			}
		}
		return dtoEmployeeList;
	}

}
