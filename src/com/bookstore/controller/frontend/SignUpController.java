package com.bookstore.controller.frontend;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.service.CustomerService;

@Controller
@RequestMapping("/customer/")
public class SignUpController {
	private String subfolder = "frontend/customer-pages/";

	@Autowired
	CustomerService customerService;
	
	@GetMapping("sign-up")
	public String showPage() {
		return subfolder + "sign-up";
	}
	
	@PostMapping("sign-up")
	public String signUp(HttpServletRequest request) {
		// check dup email (also create cus in admin)
		
		if (customerService.createCustomer(request) == null) {
			request.setAttribute("msg", "Email is already existed !!!");
			return subfolder + "sign-up";
		}
		
		return "redirect:/customer/log-in";
	}
	

}
