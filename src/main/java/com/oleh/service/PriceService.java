package com.oleh.service;

import java.math.BigDecimal;
import java.util.List;

import com.oleh.domain.PriceFilter;
import com.oleh.entity.Price;
import com.oleh.entity.Services;

public interface PriceService {

	void savePrice(Price price);
	
	Price findPriceById(int id);

	List<Price> findAllPrice();
	
	List<Price> findPriceByFilter(PriceFilter filter);
	
	BigDecimal findMaxPrice(Services service);
	
	Services findMaxPriceList(List<Services> service);
	
}
