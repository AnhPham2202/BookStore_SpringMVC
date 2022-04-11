package com.bookstore.controller.frontend.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/frontend/")
public class ViewProfileController {
	String subfolder = "frontend/customer-pages/";
	
	@GetMapping("profile")
	public String showPage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("customer") != null) {		
			
			return subfolder + "profile";
		} else {
			return "frontend/login";
		}
	}
}
