package com.project.LibraryManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.LibraryManagement.Service.MemberService;
import com.project.LibraryManagement.common.APIResponse;
import com.project.LibraryManagement.entity.Member;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;

@PostMapping(value="/member/add")
public APIResponse AddMember(@RequestBody Member member ) {
		APIResponse api =new APIResponse();
	   memberService.addNewMember(member);
		api.setData(member);
	return api;
	}

@PostMapping(value="/member/delete/{id}")
public  APIResponse DeleteMember(@PathVariable("id")long id) {
	APIResponse api =new APIResponse();
	memberService.delete(id);
	api.setData("Successfully deleted");
	return api;
}

@GetMapping(value="/member/list")
public APIResponse GetAllMember(){
	APIResponse api =new APIResponse();
	api.setData(memberService.getAllMembers());
	return api;
}

}
