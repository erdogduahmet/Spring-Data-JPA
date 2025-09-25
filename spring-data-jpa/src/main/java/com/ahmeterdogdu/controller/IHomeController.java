package com.ahmeterdogdu.controller;

import com.ahmeterdogdu.dto.DtoHome;

public interface IHomeController {

	public DtoHome findHomeById(Long id);
}
