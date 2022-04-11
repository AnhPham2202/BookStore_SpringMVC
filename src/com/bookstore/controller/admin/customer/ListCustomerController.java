package com.bookstore.controller.admin.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.entity.Customer;
import com.bookstore.service.CustomerService;

@Controller
@RequestMapping(value = "/admin/")
public class ListCustomerController {
	private String subfolder = "admin/customer-pages/";
	@Autowired
	CustomerService customerService;
	
	@GetMapping("list-customer")
	public String showPage(HttpServletRequest request) {
		List<Customer> listCustomer = customerService.listCustomer();
		request.setAttribute("listCustomer", listCustomer);
		return subfolder + "list-customer";
	}
}
