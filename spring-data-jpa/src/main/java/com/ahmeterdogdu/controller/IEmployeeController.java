package com.ahmeterdogdu.controller;

import java.util.List;

import com.ahmeterdogdu.dto.DtoEmployee;

public interface IEmployeeController {

	public List<DtoEmployee> findAllEmployees();
}
