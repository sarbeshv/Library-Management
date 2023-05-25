package com.project.LibraryManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Issue implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	private Long issueId;
	
	@Nonnull
	private Date issueDate;
	
	private Date expectedReturnDate;
	
	private Integer returned;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;
	
	@JsonIgnore
	@OneToMany(mappedBy = "issue", cascade = CascadeType.ALL)
	private  List<IssuedBook> issueBooks;

	public Long getIssueId() {
		return issueId;
	}

	public void setIssueId(Long issueId) {
		this.issueId = issueId;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getExpectedReturnDate() {
		return expectedReturnDate;
	}

	public void setExpectedReturnDate(Date expectedReturnDate) {
		this.expectedReturnDate = expectedReturnDate;
	}

	public Integer getReturned() {
		return returned;
	}

	public void setReturned(Integer returned) {
		this.returned = returned;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public List<IssuedBook> getIssueBooks() {
		return issueBooks;
	}

	public void setIssueBooks(List<IssuedBook> issueBooks) {
		this.issueBooks = issueBooks;
	}

	public Issue(Long issueId, Date issueDate, Date expectedReturnDate, Integer returned, Member member,
			List<com.project.LibraryManagement.entity.IssuedBook> issueBooks) {
		super();
		this.issueId = issueId;
		this.issueDate = issueDate;
		this.expectedReturnDate = expectedReturnDate;
		this.returned = returned;
		this.member = member;
		this.issueBooks = issueBooks;
	}

	@Override
	public String toString() {
		return "Issue [issueId=" + issueId + ", issueDate=" + issueDate + ", expectedReturnDate=" + expectedReturnDate
				+ ", returned=" + returned + ", member=" + member + ", issueBooks=" + issueBooks + "]";
	}

	public Issue() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}

