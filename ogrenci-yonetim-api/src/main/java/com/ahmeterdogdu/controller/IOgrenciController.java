package com.ahmeterdogdu.controller;

import java.util.List;

import com.ahmeterdogdu.entities.Ogrenci;

public interface IOgrenciController {
	
	public Ogrenci saveOgrenci(Ogrenci ogrenci);
	public List<Ogrenci> getAllOgrenci();
	public Ogrenci getOgrenciById(Integer id);
	public boolean deleteOgrenci(Integer id);
	public Ogrenci updateOgrenci(Integer id,Ogrenci updateOgrenci);
	public List<Ogrenci> getOgrenciWithParams(String firstName,String lastName);

}
