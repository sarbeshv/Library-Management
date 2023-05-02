package com.project.LibraryManagement.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity

@Table(name = "Users")
public class Users {

	@Id
	private int userId;
	private String userName;
	private String payment;
	private String password;
	
	@OneToMany(mappedBy = "user")
	private List<Books> BookList;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Books> getBookList() {
		return BookList;
	}

	public void setBookList(List<Books> bookList) {
		BookList = bookList;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", payment=" + payment + ", password=" + password
				+ ", BookList=" + BookList + "]";
	}

	public Users(int userId, String userName, String payment, String password, List<Books> bookList) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.payment = payment;
		this.password = password;
		BookList = bookList;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	

}
