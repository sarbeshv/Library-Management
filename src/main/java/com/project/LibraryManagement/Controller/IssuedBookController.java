package com.project.LibraryManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.LibraryManagement.Service.BookService;
import com.project.LibraryManagement.Service.IssueService;
import com.project.LibraryManagement.Service.IssuedBookService;
import com.project.LibraryManagement.common.Constant;
import com.project.LibraryManagement.entity.Books;
import com.project.LibraryManagement.entity.Issue;
import com.project.LibraryManagement.entity.IssuedBook;

@RestController
public class IssuedBookController {
	
	@Autowired
	IssuedBookService issuedBookService;
	
	@Autowired
	IssueService issueService;
	
	@Autowired
	BookService bookService;
	
	IssuedBook issued =new IssuedBook();

	@PostMapping(value ="/issuebooks/save")
	public String AddIssue(@RequestBody IssuedBook issue ) {
		issued.setReturned(Constant.BOOK_NOT_RETURNED);
		issuedBookService.addIssueBook(issue);
		return "Successful";
	}
	
	@RequestMapping(value = "/{id}/return/all", method = RequestMethod.GET)
	public String returnAll(@PathVariable(name = "id") Long id) {
		Issue issue = issueService.getIssueById(id);
		if( issue != null ) {
			List<IssuedBook> issuedBooks = issue.getIssueBooks();
			for( int k=0 ; k<issuedBooks.size() ; k++ ) {
				IssuedBook ib = issuedBooks.get(k);
				ib.setReturned( Constant.BOOK_RETURNED );
				issuedBookService.save( ib );
				
				Books book = ib.getBook();
				book.setStatusOfBook( Constant.BOOK_STATUS_AVAILABLE );
				bookService.save(book);
			}
			
			issue.setReturned( Constant.BOOK_RETURNED );
			issueService.save(issue);
			
			return "successful";
		} else {
			return "unsuccessful";
		}
	
	}
	
	@GetMapping(value ="/issuebooks/list")
	public List<IssuedBook> DisplayAll() {
		return issuedBookService.getAllIssueBook();
	}
}
