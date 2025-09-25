package com.ahmeterdogdu.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmeterdogdu.dto.DtoOgrenci;
import com.ahmeterdogdu.dto.DtoOgrenciIU;
import com.ahmeterdogdu.entities.Ogrenci;
import com.ahmeterdogdu.repository.OgrenciRepository;
import com.ahmeterdogdu.services.IOgrenciService;

@Service
public class OgrenciServiceImpl implements IOgrenciService {

	@Autowired
	private OgrenciRepository ogrenciRepository;
	
	@Override
	public DtoOgrenci saveOgrenci(DtoOgrenciIU dtoOgrenciIU) {
		Ogrenci ogrenci= new Ogrenci();
		BeanUtils.copyProperties(dtoOgrenciIU, ogrenci);
		Ogrenci dbOgrenci= ogrenciRepository.save(ogrenci);
		DtoOgrenci dtoOgrenci=new DtoOgrenci();
		BeanUtils.copyProperties(dbOgrenci, dtoOgrenci);
		return dtoOgrenci;
	}

	@Override
	public List<DtoOgrenci> getAllOgrenci() {
		List<Ogrenci> ogrenciList=new ArrayList<>();
		List<DtoOgrenci> dtoOgrenciList=new ArrayList<>();
		
		ogrenciList=ogrenciRepository.getOgrenciList();
		for (Ogrenci ogrenci : ogrenciList) {
			DtoOgrenci dtoOgrenci=new DtoOgrenci();
			BeanUtils.copyProperties(ogrenci, dtoOgrenci);
			dtoOgrenciList.add(dtoOgrenci);
		}
		return dtoOgrenciList;
	}

	@Override
	public DtoOgrenci getOgrenciById(Integer id) {
		Optional<Ogrenci> optional= ogrenciRepository.findById(id);
		if (optional.isPresent()) {
			Ogrenci dbOgrenci= optional.get();
			DtoOgrenci dtoOgrenci=new DtoOgrenci();
			BeanUtils.copyProperties(dbOgrenci, dtoOgrenci);
			return dtoOgrenci;
		}
		return null;
	}

	@Override
	public boolean deleteOgrenci(Integer id) {
		Optional<Ogrenci> ogrenciOptional=ogrenciRepository.findOgrenciById(id);
		if (ogrenciOptional.isPresent()) {
			ogrenciRepository.delete(ogrenciOptional.get());
			return true;
		}
		return false;
	}

	@Override
	public DtoOgrenci updateOgrenci(Integer id, DtoOgrenciIU updateDtoOgrenciIU) {
		Optional<Ogrenci> optional =ogrenciRepository.findById(id);
		if (optional.isPresent()) {
			Ogrenci dbOgrenci=optional.get();
			dbOgrenci.setFirstName(updateDtoOgrenciIU.getFirstName());
			dbOgrenci.setLastName(updateDtoOgrenciIU.getLastName());
			dbOgrenci.setAge(updateDtoOgrenciIU.getAge());
			Ogrenci updatedOgrenci=ogrenciRepository.save(dbOgrenci);
			DtoOgrenci dtoOgrenci=new DtoOgrenci();
			BeanUtils.copyProperties(updatedOgrenci, dtoOgrenci);
			return dtoOgrenci;
		}
		return null;
	}

	@Override
	public List<DtoOgrenci> getOgrenciWithParams(String firstName, String lastName) {
		List<Ogrenci> ogrenciList=ogrenciRepository.findByFirstNameAndLastName(firstName, lastName);
		List<DtoOgrenci> dtoOgrenciList=new ArrayList<>();
		for (Ogrenci ogrenci : ogrenciList) {
			DtoOgrenci dtoOgrenci=new DtoOgrenci();
			BeanUtils.copyProperties(ogrenci, dtoOgrenci);
			dtoOgrenciList.add(dtoOgrenci);
		}
		
		return dtoOgrenciList;
	}

}
