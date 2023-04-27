package com.project.LibraryManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
	private int book_id;
	public Books(int book_id, String book_name, String genre) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.genre = genre;
	}
	private String book_name;
	private String genre;

}
