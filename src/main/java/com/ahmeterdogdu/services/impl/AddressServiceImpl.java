package com.ahmeterdogdu.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmeterdogdu.dto.DtoAddress;
import com.ahmeterdogdu.dto.DtoCustomer;
import com.ahmeterdogdu.entities.Address;
import com.ahmeterdogdu.repository.AddressRepository;
import com.ahmeterdogdu.services.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public DtoAddress findAddressById(Long id) {
		DtoAddress dtoAddress = new DtoAddress();

		Optional<Address> optional = addressRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}

		Address address = optional.get();
		BeanUtils.copyProperties(address, dtoAddress);

		DtoCustomer dtoCustomer = new DtoCustomer();
		dtoCustomer.setId(address.getCustomer().getId());
		dtoCustomer.setName(address.getCustomer().getName());

		dtoAddress.setCustomer(dtoCustomer);
		return dtoAddress;
	}

}
