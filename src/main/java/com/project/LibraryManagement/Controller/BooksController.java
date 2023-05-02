package com.project.LibraryManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.LibraryManagement.Respository.LibraryRespository;
import com.project.LibraryManagement.Respository.UsersRespository;
import com.project.LibraryManagement.Service.LibraryService;
import com.project.LibraryManagement.entity.Books;

@RestController
public class BooksController {
	
	@Autowired
	LibraryService libraryService;
	
//	@GetMapping(value="/addBook")
//	public String addBook(@RequestBody Books book) {
//		libraryService.addBook(book);
//		return "Country added successfully";
//		
//	}
	
	@GetMapping(value = "/GetById")
	public Books GetById(@RequestParam("id") int id){
		return libraryService.viewBookById(id);
		
	}
	

}
