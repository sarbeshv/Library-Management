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
	
	@ManyToOne
	private Users issuedUser;

	private int noOfDays;
	
	@Column(name="genre")
	private String genre;

}
