package com.oleh.service;

import java.util.List;

import com.oleh.entity.Services;

public interface ServicesService {

	void saveService(Services service);
	
	Services findServiceById(int id);
	
	Services findServiceByName(String name);
	
	Services findServiceByNameNew(Services service);
	
	List<Services> findAllService();
}
