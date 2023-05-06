package com.project.LibraryManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.LibraryManagement.Exception.BookNotFoundException;
import com.project.LibraryManagement.Exception.StatusAlreadyUpdatedException;
import com.project.LibraryManagement.Respository.BookRespository;
import com.project.LibraryManagement.entity.Books;

@Service
public class BookService {

	@Autowired
	BookRespository bookRespository;
	
	public Books addBook(Books book) throws BookNotFoundException  {
		Books b = bookRespository.findById(book.getBookId()).orElse(null);
		if(b !=null)
			throw new BookNotFoundException("Book id already exist");
		book = bookRespository.save(book);
		return book;
	}
	public List<Books> getAllBooks(){
		List<Books> bookList = bookRespository.findAll();
		return bookList;
	}
	public Books viewBookById(Integer id) throws BookNotFoundException  {
		Books book = bookRespository.findById(id).orElse(null);
		if(book == null)
			throw new BookNotFoundException("Book id Not exist");
		return book;
	}
	
	//find by genre 
	public List<Books> getBookByGenre(String genre )throws BookNotFoundException{
		List<Books> book = libraryRespository.getBooksByGenre(genre);
		if(book.size()==0)
				throw new BookNotFoundException("No Book found");
		return book;
	}
	
	
	// update rented
	public String UpdateStatus(int id,int NoOfDays, int issuedUser) throws StatusAlreadyUpdatedException {
		bookRespository.updateStatus(id,NoOfDays,issuedUser);
		Books book = bookRespository.findById(id).orElse(null);
		if(book.getStatus().contains("Rented"))
			throw new  StatusAlreadyUpdatedException("Book Already Rented ");
		return " Status Updated Successfully";
	}
	
	// update available
	public String AvailUpdateStatus(int id) {
		bookRespository.availUpdateStatus(id);
		return " Status Updated Successfully";
	}
	
	public String deleteById(int id) {
		bookRespository.deleteById(id);
		return "Book is deleted";
	}
}
