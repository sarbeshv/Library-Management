package com.project.LibraryManagement.Service;

import com.project.LibraryManagement.data.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.LibraryManagement.Exception.BookNotFoundException;
import com.project.LibraryManagement.Exception.StatusAlreadyUpdatedException;
import com.project.LibraryManagement.Respository.BookRespository;
import com.project.LibraryManagement.common.APIResponse;
import com.project.LibraryManagement.entity.Books;

@Service
public class BookService {

	@Autowired
	BookRespository bookRespository;
	
	BookData bookData = new BookData();
	APIResponse response = new APIResponse();
	
	
	public APIResponse getAllBooks(){
		
		 List<Books> book = bookRespository.findAll();
		 bookData.setBooks(book);
		 response.setData(bookData);
		return response;
	}
	public APIResponse viewBookById(Integer id) throws BookNotFoundException  {
	
		BookData viewData = new BookData();
		Books book = bookRespository.findById(id).orElse(null);
		viewData.setBook(book);
		response.setData(viewData);
		if(book == null)
			throw new BookNotFoundException("Book id Not exist");
		return response;
	}
	
	//find by genre 
	public APIResponse getBookByGenre(String genre ){
		List<Books> book = bookRespository.getBooksByGenre(genre);
		bookData.setBooks(book);
		response.setData(bookData);
//		if(book.size()==0)
//				throw new BookNotFoundException("No Book found");
		return response;
	}
	
	
	// update rented
	public APIResponse UpdateStatus(int id,int NoOfDays, int issuedUser)  {
		bookRespository.updateStatus(id,NoOfDays,issuedUser);
		Books book = bookRespository.findById(id).orElse(null);
//		if(book.getStatus().contains("Rented"))
//			throw new  StatusAlreadyUpdatedException("Book Already Rented ");
		response.setData(" Status Updated Successfully");
		return response;
	}
	
	// update available
	public APIResponse AvailUpdateStatus(int id) {
		bookRespository.availUpdateStatus(id);
		response.setData( " Status Updated Successfully");
		return response;
	}
	
}
