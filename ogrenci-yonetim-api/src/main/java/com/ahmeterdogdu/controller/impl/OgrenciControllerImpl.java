package com.ahmeterdogdu.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ahmeterdogdu.controller.IOgrenciController;
import com.ahmeterdogdu.dto.DtoOgrenci;
import com.ahmeterdogdu.dto.DtoOgrenciIU;
import com.ahmeterdogdu.services.IOgrenciService;

import jakarta.validation.Valid;

@RequestMapping("/rest/api/ogrenci")
@RestController
public class OgrenciControllerImpl implements IOgrenciController {

	@Autowired
	private IOgrenciService ogrenciService;
	
	@PostMapping(path = "/save")
	@Override
	public DtoOgrenci saveOgrenci(@RequestBody @Valid DtoOgrenciIU dtoOgrenciIU) {
		return ogrenciService.saveOgrenci(dtoOgrenciIU);
	}

	@GetMapping("/list")
	@Override
	public List<DtoOgrenci> getAllOgrenci() {
		return ogrenciService.getAllOgrenci();
	}

	@GetMapping(path = "/list/{id}")
	@Override
	public DtoOgrenci getOgrenciById(@PathVariable(name = "id",required = true)Integer id) {
		return ogrenciService.getOgrenciById(id);
	}

	@DeleteMapping(path = "/delete/{id}")
	@Override
	public boolean deleteOgrenci(@PathVariable(name = "id",required = true) Integer id) {
		return ogrenciService.deleteOgrenci(id);
	}

	@PutMapping(path = "/update/{id}")
	@Override
	public DtoOgrenci updateOgrenci(@PathVariable(name = "id",required = true) Integer id,
								 @RequestBody DtoOgrenciIU updateDtoOgrenciIU) {
		return ogrenciService.updateOgrenci(id, updateDtoOgrenciIU);
	}

	@GetMapping(path = "/listWithParams")
	@Override
	public List<DtoOgrenci> getOgrenciWithParams(@RequestParam(name = "firstName",required = false) String firstName,
											  @RequestParam(name = "lastName",required = false) String lastName) {
		return ogrenciService.getOgrenciWithParams(firstName, lastName);
	}

	
}
