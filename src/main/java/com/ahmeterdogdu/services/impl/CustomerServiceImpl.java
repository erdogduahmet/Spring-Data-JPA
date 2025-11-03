package com.ahmeterdogdu.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmeterdogdu.dto.DtoAddress;
import com.ahmeterdogdu.dto.DtoCustomer;
import com.ahmeterdogdu.entities.Address;
import com.ahmeterdogdu.entities.Customer;
import com.ahmeterdogdu.repository.CustomerRepository;
import com.ahmeterdogdu.services.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public DtoCustomer findCustomerById(Long id) {
		DtoCustomer dtoCustomer=new DtoCustomer();
		DtoAddress dtoAddress=new DtoAddress();
		
		Optional<Customer> optional =customerRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		
		Customer customer=optional.get();
		Address address= optional.get().getAddress();
		BeanUtils.copyProperties(customer, dtoCustomer);
		BeanUtils.copyProperties(address, dtoAddress);
		
		dtoCustomer.setAddress(dtoAddress);
		
		return dtoCustomer;		
	}

	
}
