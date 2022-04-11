package com.bookstore.controller.admin.customer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bookstore.entity.Customer;
import com.bookstore.service.CustomerService;

@Controller
@RequestMapping(value = "/admin/")
public class UpdateCustomerController {
	private String subfolder = "admin/customer-pages/";
	@Autowired
	CustomerService customerService;
	
	@GetMapping("update-customer")
	public String showPage(@RequestParam int id, HttpServletRequest request) {
		Customer customer = customerService.getCustomerById(id);
		request.setAttribute("customer", customer);
		
		return subfolder + "update-customer";
	}
	
	@PostMapping("update-customer")
	public String updateCustomer(
			@RequestParam int id, 
			HttpServletRequest request, 
			RedirectAttributes redirect) {
		
		Customer customer = customerService.getCustomerById(id);
		
		if (customer == null) {
			redirect.addFlashAttribute("msg", "There is no customer with id " + id);
			return "redirect:/admin/list-customer";
		}
		redirect.addFlashAttribute("msg", "Update successfully !!!");
		customerService.updateCustomer(customer, request);
		return "redirect:/admin/list-customer";

	}
}
