package com.oleh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oleh.entity.Services;
import com.oleh.repository.ServiceRepository;
import com.oleh.service.ServicesService;

@Service
public class ServicesServiceImpl implements ServicesService{

	@Autowired
	private ServiceRepository serviceRepository;
	
	@Override
	public void saveService(Services service) {
		serviceRepository.save(service);
	}

	@Override
	public Services findServiceById(int id) {
		return serviceRepository.getOne(id);
	}

	@Override
	public List<Services> findAllService() {
		return serviceRepository.findAll();
	}

	@Override
	public Services findServiceByName(String name) {
		return serviceRepository.findServiceByName(name);
	}

	@Override
	public Services findServiceByNameNew(Services service) {
		return serviceRepository.findServiceByNameNew(service);
	}

	
}
