package com.project.LibraryManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.project.LibraryManagement.Service.LibraryService;
import com.project.LibraryManagement.entity.Books;

@SpringBootApplication
public class LibraryManagementApplication {
private static ApplicationContext ctx = null;
private static LibraryService libraryService = null;
	public static void main(String[] args) {
	ctx = SpringApplication.run(LibraryManagementApplication.class, args);
	libraryService = ctx.getBean(LibraryService.class);
	testAddBook();
	}
	private static void testAddBook() {
		Books book = new Books(1,"Harry potter","Fiction");
		book = libraryService.addBook(book);
	}

}
