package com.example.demo.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/error")
	public String error() {
		return "error";
	}
	
	@GetMapping("/top")
	public String top() {
		return "top";
	}	
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/accessDenied")
	public String denied() {
		return "accessDenied";
	}
	
	@GetMapping("/admin/admin")
	public String admin() {
		return "/admin/admin";
	}
	
	@GetMapping("/user/user")
	public String user() {
		return "/user/user";
	}
}
