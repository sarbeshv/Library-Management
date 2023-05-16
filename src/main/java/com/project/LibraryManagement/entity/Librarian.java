package com.project.LibraryManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Librarian {

	@Id
	private int librarian_id;
	
	private String librarian_name;
	private String email;
	private String password;
	
	
	
	
	
	public Librarian(int librarian_id, String librarian_name, String email, String password) {
		super();
		this.librarian_id = librarian_id;
		this.librarian_name = librarian_name;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Librarian [librarian_id=" + librarian_id + ", librarian_name=" + librarian_name + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	public int getLibrarian_id() {
		return librarian_id;
	}
	public void setLibrarian_id(int librarian_id) {
		this.librarian_id = librarian_id;
	}
	public String getLibrarian_name() {
		return librarian_name;
	}
	public void setLibrarian_name(String librarian_name) {
		this.librarian_name = librarian_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
