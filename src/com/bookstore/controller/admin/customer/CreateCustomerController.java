package com.bookstore.controller.admin.customer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.service.CustomerService;

@Controller
@RequestMapping(value = "/admin/")
public class CreateCustomerController {
	private String subfolder = "admin/customer-pages/";
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("create-customer")
	public String showPage() {
		return subfolder + "create-customer";
	}
	
	@PostMapping("create-customer")
	public String createCustomer(HttpServletRequest request) {		
		if (customerService.createCustomer(request) == null) {
			request.setAttribute("msg", "Email is already existed !!!");
			return subfolder + "create-customer";
		}
		
		return "redirect:/admin/list-customer";
	}
}
