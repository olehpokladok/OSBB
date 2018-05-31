package com.oleh.service;

import java.math.BigDecimal;
import java.util.List;

import com.oleh.entity.Payment;
import com.oleh.entity.User;

public interface PaymentService {

	void savePayment(Payment payment);
	
	Payment findPaymentById(int id);
	
	List<Payment> findAllPayment();
	
	List<Payment> findAllPaymentByUserId(User id);
	
	BigDecimal findAreaByUserId(User id);
	
}
