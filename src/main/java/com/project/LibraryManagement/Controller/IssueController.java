package com.project.LibraryManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class IssueController {
	
	@Autowired
	IssueService issueService;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	IssuedBookService issuedBookService;
	
	@GetMapping(value ="/issue/list")
	public List<Issue> AllIssue(){
		return issueService.getAllIssue();
	}
	
	@PostMapping(value ="/issue/new")
	public String AddIssue(@RequestBody Issue issue ) {
		issueService.addIssue(issue);
		return "Successful";
	}
	

}
