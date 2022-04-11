package com.bookstore.controller.admin.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookstore.service.OrderService;

@Controller
@RequestMapping("/admin/")
public class RemoveOrderAdminController {

	@Autowired
	OrderService orderService;
	
	@PostMapping("delete-order")
	public String removeOrder(@RequestParam int id) {
		orderService.removeOrder(id);
		return "redirect:/admin/list-order";
	}
}
