package com.ahmeterdogdu.services;

import java.util.List;

import com.ahmeterdogdu.dto.DtoOgrenci;
import com.ahmeterdogdu.dto.DtoOgrenciIU;

public interface IOgrenciService {

	public DtoOgrenci saveOgrenci(DtoOgrenciIU dtoOgrenciIU);
	public List<DtoOgrenci> getAllOgrenci();
	public DtoOgrenci getOgrenciById(Integer id);
	public boolean deleteOgrenci(Integer id);
	public DtoOgrenci updateOgrenci(Integer id,DtoOgrenciIU dtoOgrenciIU);
	public List<DtoOgrenci> getOgrenciWithParams(String firstName,String lastName);
}
