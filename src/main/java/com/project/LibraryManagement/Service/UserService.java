package com.project.LibraryManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.LibraryManagement.Exception.BookNotFoundException;
import com.project.LibraryManagement.Exception.UserNotFoundException;
import com.project.LibraryManagement.Respository.BookRespository;
import com.project.LibraryManagement.Respository.UsersRespository;
import com.project.LibraryManagement.entity.Books;
import com.project.LibraryManagement.entity.Users;
import com.project.LibraryManagement.util.JwtUtils;

@Service
public class UserService {

	@Autowired
	private UsersRespository userRepo;

	@Autowired
	private BookRespository bookRepo;

	
	
	//add
	public Users addUsers(Users users) {
		return userRepo.save(users);
	}

	
	//find all
	public List<Users> getAllUsers() {
		List<Users> bookList = (List<Users>) userRepo.findAll();
		return bookList;
	}
      

	// find
	public Users GetUserById(Long id) throws UserNotFoundException {
		Users user = userRepo.findById(id).orElse(null);
		if (user == null)
			throw new UserNotFoundException("User id Not exist");
		return user;
	}
	

//	// payment
//	public Integer calculatePayment(Long id) throws BookNotFoundException {
//		Users user = userRepo.findById(id).orElse(null);
//		Books book = null;
//		Integer payment = 0;
//		Integer count = user.getBookList().size();
//		if (count < 0)
//			throw new BookNotFoundException("User does not rented any books");
//
//		payment = count * book.getNoOfDays() * 50;
//		user.setPayment(Integer.toString(payment));
//		userRepo.save (user);
//
//		return payment;

	}
	
//	public Integer NoOfBooksRented() {
//		Users user = null;
//		int count = 0;
//		for (Books i : user.getBookList()) {
//			count++;
//		}
//		return count;
//	}


