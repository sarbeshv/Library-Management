package com.project.LibraryManagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "bookId")
public class Books {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	
	private String bookName;
	private String Author;
	private  String status;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="issuedUser")
	private Users issuedUser;
	
	@Column(nullable = true)
	private Integer noOfDays;
	
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

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
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

	public Integer getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(Integer noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", bookName=" + bookName + ", Author=" + Author + ", status=" + status
				+ ", issuedUser=" + issuedUser + ", noOfDays=" + noOfDays + ", genre=" + genre + "]";
	}

	public Books(int bookId, String bookName, String author, String status, Users issuedUser, Integer noOfDays,
			String genre) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		Author = author;
		this.status = status;
		this.issuedUser = issuedUser;
		this.noOfDays = noOfDays;
		this.genre = genre;
	}

	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}

		
}
