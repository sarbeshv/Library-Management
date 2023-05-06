package com.project.LibraryManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.LibraryManagement.Exception.BookNotFoundException;
import com.project.LibraryManagement.Exception.StatusAlreadyUpdatedException;
import com.project.LibraryManagement.Service.BookService;
import com.project.LibraryManagement.entity.Books;

@RestController
public class BooksController {
	
	@Autowired
	BookService BookService;
	
	@PostMapping(value="/addBook")
	public Books addBook(@RequestBody Books book) throws BookNotFoundException {
//		try {
		return	BookService.addBook(book);
//		} catch (BookNotFoundException e) {
//			e.toString();
//		}
//		return "Book added successfully";
		
	}
	
	@GetMapping(value ="/AllBooks")
	public List<Books> AllBooks(){
		return BookService.getAllBooks();
	}
	
	@GetMapping(value = "/GetById/{id}")
	public Books GetById(@PathVariable("id") int id){
		Books book = null;
		try {
			 book =BookService.viewBookById(id);
		} catch (BookNotFoundException e) {
			
			e.toString();
		}
		return book;
	}
	
	@PutMapping(value ="/UpdateStatus/{id}/{Days}/{issuedUser}")
	public String updateBookStatus(@PathVariable("id") int id,@PathVariable("Days")int Days,@PathVariable("issuedUser")int issuedUser ) {
		String status = null;
		try {
			status = BookService.UpdateStatus(id,Days,issuedUser);
		} catch (StatusAlreadyUpdatedException e) {
			
			e.toString();
		}
		return "Book Rented Successfully";
	}
	
	@PutMapping(value ="/availableUpdate/{id}")
	public String availUpdateBookStatus(@PathVariable("id")int id) {
		return BookService.AvailUpdateStatus(id);
	}
	
	@DeleteMapping(value="/deleteBook/{id}")
	public String DeleteById(@PathVariable("id")int id) {
		return BookService.deleteById(id);
	}

}
