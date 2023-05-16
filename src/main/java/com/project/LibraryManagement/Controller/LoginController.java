package com.project.LibraryManagement.Controller;

import com.project.LibraryManagement.DTO.LoginRequestDTO;
import com.project.LibraryManagement.DTO.SignUpRequestDTO;
import com.project.LibraryManagement.Service.LoginService;
import  com.project.LibraryManagement.common.APIResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;

	@PostMapping("/signup")
	public ResponseEntity<APIResponse> signUp( @RequestBody SignUpRequestDTO signupDTo) {
		APIResponse response = loginService.signUp(signupDTo);
		
		return ResponseEntity
				.status(response.getStatus())
				.body(response);
	}
	
	
	@PostMapping("/Login")
	public ResponseEntity<APIResponse> login( @RequestBody LoginRequestDTO loginDto) {
		APIResponse response = loginService.login(loginDto);
		
		return ResponseEntity
				.status(response.getStatus())
				.body(response);
	}



}
