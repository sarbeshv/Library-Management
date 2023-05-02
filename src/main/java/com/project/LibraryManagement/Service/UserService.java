package com.project.LibraryManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.LibraryManagement.Exception.UserNotFoundException;
import com.project.LibraryManagement.Respository.UsersRespository;
import com.project.LibraryManagement.entity.Books;
import com.project.LibraryManagement.entity.Users;

@Service
public class UserService {

	@Autowired
	private UsersRespository userRepo;
	
	public  Users addUsers(Users users) {
		return userRepo.save(users);
	}
	
	public List<Users> getAllUsers(){
		List<Users> bookList = userRepo.findAll();
		return bookList;
	}
	
	public Integer NoOfBooksRented() {
		Users user = null;
		int count =0;
		for( Books i : user.getBookList()) {
			count++;
		}
		 return count;
	}
	public Users GetUserById(Integer id) throws UserNotFoundException  {
		Users user = userRepo.findById(id).orElse(null);
		if(user == null)
			throw new UserNotFoundException("User id Not exist");
		return user;
	}
	
}

