package com.project.LibraryManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Payment {
 
	@Id
	private int userId;
	
	private int totalPayment;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTotalPayment() {
		return totalPayment;
	}
	public void setTotalPayment(int totalPayment) {
		this.totalPayment = totalPayment;
	}
	@Override
	public String toString() {
		return "Payment [userId=" + userId + ", totalPayment=" + totalPayment + "]";
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(int userId, int totalPayment) {
		super();
		this.userId = userId;
		this.totalPayment = totalPayment;
	}
	
}
