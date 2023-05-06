package com.project.LibraryManagement.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity

@Table(name = "Users")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "userId")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;
	private String payment;
	private String password;
	
	@OneToMany(mappedBy = "issuedUser",fetch = FetchType.EAGER)
	@JsonIgnore
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
