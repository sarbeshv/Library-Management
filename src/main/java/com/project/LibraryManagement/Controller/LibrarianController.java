package com.project.LibraryManagement.Controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.LibraryManagement.Exception.BookNotFoundException;
import com.project.LibraryManagement.Service.LibrarianService;
import com.project.LibraryManagement.entity.Books;


@RestController
public class LibrarianController {
	
	@Autowired
	LibrarianService libService;
	
	@PostMapping(value="/addBook")
	public Books addBook(@RequestBody Books book) throws BookNotFoundException {
		return	libService.addBook(book);
		
	}
	
	
	@DeleteMapping(value="/deleteBook/{id}")
	public String DeleteById(@PathVariable("id")int id) {
		return libService.deleteById(id);
	}
}


