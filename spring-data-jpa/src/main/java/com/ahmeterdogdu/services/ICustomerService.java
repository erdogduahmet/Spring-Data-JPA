package com.ahmeterdogdu.services;

import com.ahmeterdogdu.dto.DtoCustomer;

public interface ICustomerService {
	
	public DtoCustomer findCustomerById(Long id);

}
