package com.bookstore.controller.frontend;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class LoginController {
	String subfolder = "frontend/";
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/log-in")
	public String showLogInPage() {
		return subfolder + "login";
	}
	
	@PostMapping("/log-in")
	public String logIn(HttpServletRequest request) {
		customerService.logIn(request);
		HttpSession session = request.getSession();
		if (session.getAttribute("customer") == null) {
			request.setAttribute("msg", "Email or password is incorrect !!!");
			return subfolder + "login";
		} else {
			return "redirect:/frontend";
		}

	}
	
}
