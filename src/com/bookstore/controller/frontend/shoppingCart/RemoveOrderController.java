package com.bookstore.controller.frontend.shoppingCart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookstore.entity.Book;
import com.bookstore.entity.ShoppingCart;
import com.bookstore.service.BookService;

@Controller
@RequestMapping("/frontend/")
public class RemoveOrderController {
	@Autowired
	BookService bookService;
	@Autowired
	ShoppingCart shoppingCart;
	
	String subfoler = "frontend/shopping-cart/";
	@PostMapping("shopping-cart/remove")
	public String createOrder(@RequestParam int id, HttpServletRequest request) {
		HttpSession session  = request.getSession();
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		Book b = bookService.getBookFromId(id);
		cart.removeItem(b);
		session.setAttribute("cart", cart);
		return  "redirect:/frontend/shopping-cart";
	}
}
