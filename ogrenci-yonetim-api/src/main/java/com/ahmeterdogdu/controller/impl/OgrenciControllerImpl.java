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
import com.ahmeterdogdu.entities.Ogrenci;
import com.ahmeterdogdu.services.IOgrenciService;

@RequestMapping("/rest/api/ogrenci")
@RestController
public class OgrenciControllerImpl implements IOgrenciController {

	@Autowired
	private IOgrenciService ogrenciService;
	
	@PostMapping(path = "/save")
	@Override
	public Ogrenci saveOgrenci(@RequestBody Ogrenci ogrenci) {
		return ogrenciService.saveOgrenci(ogrenci);
	}

	@GetMapping("/list")
	@Override
	public List<Ogrenci> getAllOgrenci() {
		return ogrenciService.getAllOgrenci();
	}

	@GetMapping(path = "/list/{id}")
	@Override
	public Ogrenci getOgrenciById(@PathVariable(name = "id",required = true)Integer id) {
		return ogrenciService.getOgrenciById(id);
	}

	@DeleteMapping(path = "/delete/{id}")
	@Override
	public boolean deleteOgrenci(@PathVariable(name = "id",required = true) Integer id) {
		return ogrenciService.deleteOgrenci(id);
	}

	@PutMapping(path = "/update/{id}")
	@Override
	public Ogrenci updateOgrenci(@PathVariable(name = "id",required = true) Integer id,
								 @RequestBody Ogrenci updateOgrenci) {
		return ogrenciService.updateOgrenci(id, updateOgrenci);
	}

	@GetMapping(path = "/listWithParams")
	@Override
	public List<Ogrenci> getOgrenciWithParams(@RequestParam(name = "firstName",required = false) String firstName,
											  @RequestParam(name = "lastName",required = false) String lastName) {
		return ogrenciService.getOgrenciWithParams(firstName, lastName);
	}

	
}
