package com.bookstore.controller.admin.order;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bookstore.entity.BookOrder;
import com.bookstore.service.OrderService;

@Controller
@RequestMapping("/admin/")
public class UpdateOrderController {
	private String subfolder = "admin/order-pages/";
	@Autowired
	OrderService orderService;
	
	
	@GetMapping("update-order")
	public String showPage(@RequestParam int id, HttpServletRequest request) {
		BookOrder order = orderService.getOrderById(id);
		request.setAttribute("order", order);
		return subfolder + "update-order";
	}
	
	@PostMapping("update-order")
	public String updateOrder(@RequestParam int id, HttpServletRequest request, RedirectAttributes redirect) {
		redirect.addFlashAttribute("msg", "Update order successfully !!!");
		orderService.updateOrder(request, id);
		return "redirect:/admin/list-order";
	}
}
