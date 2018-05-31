package com.oleh.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oleh.entity.Payment;
import com.oleh.entity.User;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

	@Query("SELECT p FROM Payment p WHERE p.user_id = :id")
	List<Payment> findPaymentByUserId(@Param("id") User user_id);
	
	@Query("SELECT u.area FROM User u WHERE u.id = :id")
	BigDecimal findAreaByUserId(@Param("id") User id);
}
