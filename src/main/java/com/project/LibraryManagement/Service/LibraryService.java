package com.project.LibraryManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.LibraryManagement.Exception.BookNotFoundException;
import com.project.LibraryManagement.Respository.LibraryRespository;
import com.project.LibraryManagement.entity.Books;

@Service
public class LibraryService {

	@Autowired
	LibraryRespository libraryRespository;
	
	public Books addBook(Books book) throws BookNotFoundException  {
		Books b = libraryRespository.findById(book.getBookId()).orElse(null);
		if(b !=null)
			throw new BookNotFoundException("Book id already exist");
		book = libraryRespository.save(book);
		return book;
	}
	public List<Books> getAllBooks(){
		List<Books> bookList = libraryRespository.findAll();
		return bookList;
	}
	public Books viewBookById(Integer id) throws BookNotFoundException  {
		Books book = libraryRespository.findById(id).orElse(null);
		if(book == null)
			throw new BookNotFoundException("Book id Not exist");
		return book;
	}
//	public List<Books> getBookByGenre(String genre )throws BookNotFoundException{
//		List<Books> book = libraryRespository.getBooksByGenre(genre);
//		if(book.size()==0)
//				throw new BookNotFoundException("No Book found");
//		return book;
//	}
	public String UpdateStatus(Integer id) {
		libraryRespository.updateStatus(id);
		return " Status Updated Successfully";
	}
}
