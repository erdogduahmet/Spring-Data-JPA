package com.ahmeterdogdu.services;

import java.util.List;

import com.ahmeterdogdu.dto.DtoEmployee;

public interface IEmployeeService {

	public List<DtoEmployee> findAllEmployees();
}
