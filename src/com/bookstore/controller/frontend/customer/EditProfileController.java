package com.bookstore.controller.frontend.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookstore.entity.Customer;
import com.bookstore.service.CustomerService;
@Controller
@RequestMapping(value = "/frontend/")
public class EditProfileController {
	private String subfolder = "frontend/customer-pages/";

	@Autowired
	CustomerService customerService;
	
	@PostMapping("update-customer")
	public String showPage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		customerService.updateCustomer(customer, request);
		return subfolder + "profile";
	}
	
}
