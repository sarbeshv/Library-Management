package com.project.LibraryManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.LibraryManagement.Exception.BookNotFoundException;
import com.project.LibraryManagement.Service.BookService;
import com.project.LibraryManagement.entity.Books;

@RestController
public class BooksController {
	
	@Autowired
	BookService libraryService;
	
	@GetMapping(value="/addBook")
	public String addBook(@RequestBody Books book) {
		try {
			libraryService.addBook(book);
		} catch (BookNotFoundException e) {
			e.toString();
		}
		return "Country added successfully";
		
	}
	
	@GetMapping(value ="/AllBooks")
	public List<Books> AllBooks(){
		return libraryService.getAllBooks();
	}
	
	@GetMapping(value = "/GetById")
	public Books GetById(@RequestParam("id") int id){
		Books book = null;
		try {
			 book =libraryService.viewBookById(id);
		} catch (BookNotFoundException e) {
			
			e.toString();
		}
		return book;
	}
	
	@PutMapping(value ="/UpdateStatus")
	public String updateStatus(@RequestParam("id") int id ) {
		return libraryService.UpdateStatus(id);
	}
	

}
