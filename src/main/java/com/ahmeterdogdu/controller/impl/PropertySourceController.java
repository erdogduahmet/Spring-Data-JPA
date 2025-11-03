package com.ahmeterdogdu.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahmeterdogdu.configuration.DataSource;
import com.ahmeterdogdu.configuration.GlobalProperties;
import com.ahmeterdogdu.configuration.Server;

@RestController
@RequestMapping("/rest/api/property")
public class PropertySourceController {

	@Autowired
	private GlobalProperties globalProperties;
	
	//value daki işlemler için olan servis,datasource çekme servisi
//		@GetMapping("/datasource")
//		public DataSource getDataSoruce() {
//		DataSource dataSource=new DataSource();
//		dataSource.setUrl(globalProperties.getUrl());
//		dataSource.setUsername(globalProperties.getUsername());
//		dataSource.setPassword(globalProperties.getPassword());
//		return dataSource;
//	}
	@GetMapping(value = "/getServers")
	public List<Server> getServers(){
		System.out.println("Key Değerim: "+globalProperties.getKey());
		return globalProperties.getServers();
	}
}
