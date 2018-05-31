package com.oleh.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.oleh.domain.PriceFilter;
import com.oleh.entity.Price;
import com.oleh.entity.Services;
import com.oleh.repository.PriceRepository;
import com.oleh.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	private PriceRepository priceRepository;

	@Override
	public void savePrice(Price price) {
		priceRepository.save(price);
	}

	@Override
	public Price findPriceById(int id) {
		return priceRepository.getOne(id);
	}

	@Override
	public List<Price> findAllPrice() {
		return priceRepository.findAll();
	}

	@Override
	public BigDecimal findMaxPrice(Services service) {
		return priceRepository.findMaxPrice(service);
	}
	
	

	@Override
	public Services findMaxPriceList(List<Services> service) {
		return priceRepository.findMaxPriceList(service);
	}

	@Override
	public List<Price> findPriceByFilter(PriceFilter filter) {
		return priceRepository.findAll(getSpecification(filter));
	}
	
	private Specification<Price> getSpecification(PriceFilter filter) {
		return new Specification<Price>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Price> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//				if (filter.getSearch().isEmpty())
//					return null;

				return cb.like(root.get("services"), "%" + filter.getSearch() + "%");
			}

		};
	}
	
	

	
}
