package com.oleh.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oleh.entity.Price;
import com.oleh.entity.Services;

public interface PriceRepository extends JpaRepository<Price, Integer>, JpaSpecificationExecutor<Price>	{
//	максимальне знайти
	@Query("SELECT max(p.price) FROM Price p WHERE p.services = :service")
	BigDecimal findMaxPrice(@Param("service") Services service);
	
	@Query("SELECT max(p.price) FROM Price p WHERE p.services = :service")
	Services findMaxPriceList(@Param("service") List<Services> service);
}
