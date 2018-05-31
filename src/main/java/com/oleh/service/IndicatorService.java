	package com.oleh.service;

import java.math.BigDecimal;
import java.util.List;

import com.oleh.entity.Indicator;
import com.oleh.entity.Services;
import com.oleh.entity.User;

public interface IndicatorService {

	void saveIndicator(Indicator indicator);
	
	Indicator findIndicatorById(int id);
	
	List<Indicator> findAllIndicator();
	
	Integer findMaxCounter(Services service);
	
	List<Indicator> findAllIndicatorByService(Services service);
	
	List<Indicator> findAllIndicatorByUserId(User user_id);
	
	BigDecimal findMaxIndicatorByServiceAndUser(int serviceId, int userId);
}
