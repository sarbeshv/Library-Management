package com.project.LibraryManagement.entity;



import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "issue")
public class Issue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Nonnull
	@Column(name = "issue_date")
	private Date issueDate;
	
	@Column(name = "notes")
	private String notes;
	
	@Column(name = "expected_return_date")
	private Date expectedReturnDate;
	
	@Column(name = "returned")
	private Integer returned;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;
	
	@JsonIgnore
	@OneToMany(mappedBy = "issue", cascade = CascadeType.ALL)
	private List<IssuedBook> issuedBooks;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getExpectedReturnDate() {
		return expectedReturnDate;
	}

	public void setExpectedReturnDate(Date expectedReturnDate) {
		this.expectedReturnDate = expectedReturnDate;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public List<IssuedBook> getIssuedBooks() {
		return issuedBooks;
	}

	public void setIssuedBooks(List<IssuedBook> issuedBooks) {
		this.issuedBooks = issuedBooks;
	}

	public Integer getReturned() {
		return returned;
	}

	public void setReturned(Integer returned) {
		this.returned = returned;
	}
	
}
