package com.oleh.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oleh.entity.Indicator;
import com.oleh.entity.Services;
import com.oleh.entity.User;
import com.oleh.repository.IndicatorRepository;
import com.oleh.service.IndicatorService;

@Service
public class IndicatorServiceImpl implements IndicatorService{
	
	@Autowired
	private IndicatorRepository indicatorRepository;

	@Override
	public void saveIndicator(Indicator indicator) {
	indicatorRepository.save(indicator);	
	}

	@Override
	public Indicator findIndicatorById(int id) {
		return indicatorRepository.getOne(id);
	}

	@Override
	public List<Indicator> findAllIndicator() {
		return indicatorRepository.findAll();
	}

	@Override
	public Integer findMaxCounter(Services service) {
		return indicatorRepository.findMaxCounter(service);
	}

	@Override
	public List<Indicator> findAllIndicatorByService(Services service) {
		return indicatorRepository.findAllIndikatorByService(service);
	}

	@Override
	public List<Indicator> findAllIndicatorByUserId(User user_id) {
		return indicatorRepository.findAllIndikatorByUserId(user_id);
	}

	@Override
	public BigDecimal findMaxIndicatorByServiceAndUser(int serviceId, int userId) {
		return indicatorRepository.findMaxIndicatorByServiceAndUser(serviceId, userId);
	}
	
	

}
