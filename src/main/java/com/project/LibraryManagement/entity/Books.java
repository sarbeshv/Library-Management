package com.project.LibraryManagement.entity;

 
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.project.LibraryManagement.common.Constant;

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

public class Books {
	
	
    @GeneratedValue
	@Id
	private int bookId;
	
	private String bookName;
	private String Author;
	private Integer statusOfBook;
	
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

	public Integer getStatusOfBook() {
		return statusOfBook;
	}

	public void setStatusOfBook(Integer statusOfBook) {
		this.statusOfBook = statusOfBook;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Books(int bookId, String bookName, String author, Integer statusOfBook, String genre) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		Author = author;
		this.statusOfBook = statusOfBook;
		this.genre = genre;
	}

	public Books() {
		// TODO Auto-generated constructor stub
	}

	
}