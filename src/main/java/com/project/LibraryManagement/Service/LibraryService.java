package com.project.LibraryManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.LibraryManagement.Respository.LibraryRespository;
import com.project.LibraryManagement.entity.Books;

@Service
public class LibraryService {

	@Autowired
	LibraryRespository libraryRespository;
	
	public Books addBook(Books book) {
		book = libraryRespository.save(book);
		return book;
	}
}
