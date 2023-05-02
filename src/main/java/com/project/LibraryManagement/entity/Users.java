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
	private int email;
	private String userName;
	private String password;
	
	@OneToMany(mappedBy = "user")
	private List<Books> BookList;

	public int getUserId() {
		return email;
	}

	public void setUserId(int userId) {
		this.email = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
		return "Users [userId=" + email + ", userName=" + userName + ", password=" + password + ", BookList="
				+ BookList + "]";
	}

	public Users(int userId, String userName, String password, List<Books> bookList) {
		super();
		this.email = userId;
		this.userName = userName;
		this.password = password;
		BookList = bookList;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
