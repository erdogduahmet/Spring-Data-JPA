package com.ahmeterdogdu.services;

import com.ahmeterdogdu.dto.DtoHome;

public interface IHomeService {
	
	public DtoHome findHomeById(Long id);

}
