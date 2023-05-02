package com.project.LibraryManagement.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.LibraryManagement.entity.Payment;

@Repository
public interface PaymentRespository extends JpaRepository<Payment,Integer>{
	

}

