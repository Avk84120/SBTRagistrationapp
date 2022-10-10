package com.prog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.prog.entity.UserDtls;

@Autowired
private UserRepository repo;


@Controller
public class UserController {
	
	@GetMapping("/")
	public String home() 
	{
		return "index";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute UserDtls u,HttpSession session)
	{
		System.out.println(u);
		
		repo.save(u);
		
		session.setAttribute("message" ,"User Register Sucsessfully...");
		
		return "redirect:/";
	}

}
