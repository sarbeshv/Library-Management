package com.project.LibraryManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.LibraryManagement.Exception.UserNotFoundException;
import com.project.LibraryManagement.Service.UserService;
import com.project.LibraryManagement.entity.Users;

@RestController
public class UsersController {
  
	@Autowired
	UserService userService;
	
	@PostMapping(value = "/AddUser")
	public Users AddUsers(@RequestBody Users users ) {
		
		userService.addUsers(users);
		return users;
	}
	
	@GetMapping(value = "/findByUserId")
	public Users findByUserId(int id){
		Users user = null;
		try {
			user = userService.GetUserById(id);
		} catch (UserNotFoundException e) {
			
			e.toString();
		}
		return user;
	}
	
	@GetMapping(value = "/findAllUsers")
	public List<Users> findAllUsers(){
		return userService.getAllUsers();
	}
	
}
