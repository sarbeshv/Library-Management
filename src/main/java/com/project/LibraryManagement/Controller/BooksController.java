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
import com.project.LibraryManagement.common.APIResponse;
import com.project.LibraryManagement.entity.Books;

@RestController
public class BooksController {
	
	@Autowired
	BookService BookService;
	
	
	
	@GetMapping(value ="/AllBooks")
	public APIResponse AllBooks(){
		return BookService.getAllBooks();
	}

	
	@GetMapping(value = "/GetById/{id}")
	public APIResponse GetById(@PathVariable("id") int id){
		APIResponse Response= null;
		try {
			 Response =BookService.viewBookById(id);
		} catch (BookNotFoundException e) {
			
			e.toString();
		}
		return Response;
	}
//	@GetMapping(value ="/GetByGenre/{input}")
//	public APIResponse GetBooksByGenre(@PathVariable("input") String input){
//	      return BookService.getBookByGenre(input);
//	}
	
	@PutMapping(value ="/IssueBook/{id}/{Days}/{issuedUser}")
	public APIResponse updateBookStatus(@PathVariable("id") int id,@PathVariable("Days")int Days,@PathVariable("issuedUser")int issuedUser ) {
//		try {
			
		return BookService.UpdateStatus(id,Days,issuedUser);
//		} catch (StatusAlreadyUpdatedException e) {
//			
//			e.toString();
//		}
	//	return apiResponse;
	}
	
	@PutMapping(value ="/availableUpdate/{id}")
	public APIResponse availUpdateBookStatus(@PathVariable("id")int id) {
		return BookService.AvailUpdateStatus(id);
	}

	

}
