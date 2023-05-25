package com.project.LibraryManagement.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class IssuedBook {

	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "book_id")
	@Nonnull
	private Books book;
	
	

	@ManyToOne
	@JoinColumn(name = "issue_id")
	private Issue issue;
	
	private Integer returned;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
	}

	public Issue getIssue() {
		return issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}

	public Integer getReturned() {
		return returned;
	}

	public void setReturned(Integer returned) {
		this.returned = returned;
	}

	public IssuedBook(Long id, Books book, Issue issue, Integer returned) {
		super();
		this.id = id;
		this.book = book;
		this.issue = issue;
		this.returned = returned;
	}

	public IssuedBook() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "IssuedBook [id=" + id + ", book=" + book + ", issue=" + issue + ", returned=" + returned + "]";
	}




	
}
