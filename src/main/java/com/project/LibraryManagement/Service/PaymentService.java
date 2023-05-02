package com.project.LibraryManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.LibraryManagement.Respository.PaymentRespository;
import com.project.LibraryManagement.entity.Payment;

@Service
public class PaymentService {
	
	@Autowired
	PaymentRespository payRepo;
	
	public Payment addPayment(Payment payment)  {
		payment = payRepo.save(payment);
		return payment;
	}

}
