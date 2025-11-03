package com.ahmeterdogdu.controller;

import com.ahmeterdogdu.dto.DtoAddress;

public interface IAddressController {
	
	public DtoAddress findAddressById(Long id);

}
