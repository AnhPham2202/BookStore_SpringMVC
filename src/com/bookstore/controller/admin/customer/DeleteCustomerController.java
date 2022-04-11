package com.bookstore.controller.admin.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bookstore.service.CustomerService;

@Controller
@RequestMapping(value = "/admin/")
public class DeleteCustomerController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("delete-customer")
	public String showPage(@RequestParam int id, RedirectAttributes redirect) {
		
		if (customerService.getCustomerById(id) != null) {
			redirect.addFlashAttribute("msg", "Delete successfully !!!");
			customerService.deleteCustomer(id);
			return "redirect:/admin/list-customer";
		} else {
			redirect.addFlashAttribute("msg", "No customer with id " + id + "found");
			return "redirect:/admin/list-customer";

		}
	}
}
