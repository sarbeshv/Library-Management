package com.project.LibraryManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.LibraryManagement.Respository.UsersRespository;
import com.project.LibraryManagement.entity.Users;

@Service
public class UserService {

	@Autowired
	private UsersRespository userRepo;
	
	public  Users addUsers(Users users) {
		return userRepo.save(users);
	}
}


