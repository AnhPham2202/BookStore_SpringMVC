package com.bookstore.controller.frontend;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class LogOutController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/log-out")
	public String showLogInPage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("customer");
		return "redirect:/frontend";
	}
}
