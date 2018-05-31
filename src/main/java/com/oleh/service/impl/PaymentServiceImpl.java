package com.oleh.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oleh.entity.Payment;
import com.oleh.entity.User;
import com.oleh.repository.PaymentRepository;
import com.oleh.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public void savePayment(Payment payment) {
		paymentRepository.save(payment);
	}

	@Override
	public Payment findPaymentById(int id) {
		return paymentRepository.getOne(id);
	}

	@Override
	public List<Payment> findAllPayment() {
		return paymentRepository.findAll();
	}

	@Override
	public List<Payment> findAllPaymentByUserId(User user_id) {
		return paymentRepository.findPaymentByUserId(user_id);
	}

	@Override
	public BigDecimal findAreaByUserId(User id) {
		return paymentRepository.findAreaByUserId(id);
	}
	
	

//	@Override
//	public Integer findMaxCounter(Indicator counter) {
//		return paymentRepository.findMaxCounter(counter);
//	}

	
}
