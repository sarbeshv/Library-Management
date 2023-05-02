package com.project.LibraryManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name ="Books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Books {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	
	private String bookName;
	private  String status;
	
	@ManyToOne
	private Users issuedUser;

	private int noOfDays;
	
	@Column(name="genre")
	private String genre;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Users getIssuedUser() {
		return issuedUser;
	}

	public void setIssuedUser(Users issuedUser) {
		this.issuedUser = issuedUser;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Books(int bookId, String bookName, String status, Users issuedUser, int noOfDays, String genre) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.status = status;
		this.issuedUser = issuedUser;
		this.noOfDays = noOfDays;
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", bookName=" + bookName + ", status=" + status + ", issuedUser="
				+ issuedUser + ", noOfDays=" + noOfDays + ", genre=" + genre + "]";
	}

	
}
