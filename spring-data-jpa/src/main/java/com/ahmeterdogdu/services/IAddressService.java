package com.ahmeterdogdu.services;

import com.ahmeterdogdu.dto.DtoAddress;

public interface IAddressService {
	
	public DtoAddress findAddressById(Long id);

}
