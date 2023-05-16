package com.project.LibraryManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.LibraryManagement.Exception.BookNotFoundException;
import com.project.LibraryManagement.Respository.BookRespository;
import com.project.LibraryManagement.entity.Books;


@Service
public class LibrarianService {
	
	@Autowired
    BookRespository bookRepo;
	
	public Books addBook(Books book) throws BookNotFoundException  {
		Books b = bookRepo.findById(book.getBookId()).orElse(null);
		if(b !=null)
			throw new BookNotFoundException("Book id already exist");
		book = bookRepo.save(book);
		return book;
	}
	
	public String deleteById(int id) {
		bookRepo.deleteById(id);
		return "Book is deleted";
	}
}

