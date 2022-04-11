package com.bookstore.controller.frontend.shoppingCart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.entity.Customer;
import com.bookstore.entity.ShoppingCart;
import com.bookstore.service.BookService;

@Controller
@RequestMapping("/frontend/")
public class ViewCartController {
	
	String subfoler = "frontend/shopping-cart/";

	@Autowired
	BookService demo;
	@Autowired
	ShoppingCart shoppingCart;
	@GetMapping("shopping-cart")
	public String showPage(HttpServletRequest request) {
		HttpSession session  = request.getSession();
		return subfoler + "view-cart";
	}
}
