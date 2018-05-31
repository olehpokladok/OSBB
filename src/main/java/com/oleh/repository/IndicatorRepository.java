package com.oleh.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oleh.entity.Indicator;
import com.oleh.entity.Services;
import com.oleh.entity.User;

public interface IndicatorRepository  extends JpaRepository<Indicator, Integer>{

	@Query("SELECT max(i.counter) FROM Indicator i WHERE i.services = :service")
	Integer findMaxCounter(@Param("service") Services service);

	@Query("SELECT i.counter FROM Indicator i WHERE i.services = :service")
	List<Indicator> findAllIndikatorByService(@Param("service") Services service);
	
	@Query("SELECT i FROM Indicator i WHERE i.user_id = :id")
	List<Indicator> findAllIndikatorByUserId(@Param("id") User user_id);
	
	@Query("SELECT max(i.counter) FROM Indicator i WHERE i.services.id = :services AND i.user_id.id = :user ")
	BigDecimal findMaxIndicatorByServiceAndUser(@Param("services") int serviceId, @Param("user") int userId);
}
