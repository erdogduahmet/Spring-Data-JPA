package com.ahmeterdogdu.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmeterdogdu.entities.Ogrenci;
import com.ahmeterdogdu.repository.OgrenciRepository;
import com.ahmeterdogdu.services.IOgrenciService;

@Service
public class OgrenciServiceImpl implements IOgrenciService {

	@Autowired
	private OgrenciRepository ogrenciRepository;
	
	@Override
	public Ogrenci saveOgrenci(Ogrenci ogrenci) {
		return ogrenciRepository.save(ogrenci);
	}

	@Override
	public List<Ogrenci> getAllOgrenci() {
		return ogrenciRepository.findAll();
	}

	@Override
	public Ogrenci getOgrenciById(Integer id) {
		Optional<Ogrenci> optional= ogrenciRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public boolean deleteOgrenci(Integer id) {
		if (getOgrenciById(id)!=null) {
			ogrenciRepository.delete(getOgrenciById(id));
			return true;
		}
		return false;
	}

	@Override
	public Ogrenci updateOgrenci(Integer id, Ogrenci updateOgrenci) {
		Ogrenci dbOgrenci=getOgrenciById(id);
		if (dbOgrenci!=null) {
			dbOgrenci.setFirstName(updateOgrenci.getFirstName());
			dbOgrenci.setLastName(updateOgrenci.getLastName());
			dbOgrenci.setAge(updateOgrenci.getAge());
			return ogrenciRepository.save(dbOgrenci);
		}
		return null;
	}

	@Override
	public List<Ogrenci> getOgrenciWithParams(String firstName, String lastName) {
		return ogrenciRepository.findByFirstNameAndLastName(firstName, lastName);
	}

}
