package com.bookstore.controller.frontend.shoppingCart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookstore.entity.ShoppingCart;
import com.bookstore.service.BookService;

@Controller
@RequestMapping("/frontend/")
public class UpdateShoppingCartController {
	@Autowired
	BookService bookService;
	@Autowired
	ShoppingCart shoppingCart;
	
	String subfoler = "frontend/shopping-cart/";
	@PostMapping("shopping-cart/update")
	public String createOrder(@RequestParam int id, @RequestParam int quantity, HttpServletRequest request) {
		HttpSession session  = request.getSession();
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		
		if (quantity > 0) {
			cart.updateItem(bookService.getBookFromId(id), quantity);
			session.setAttribute("cart", cart);
		} else {
			request.setAttribute("msg", "Quantity can't be equal or lower than 0 !!!");
		}
		
		return  "redirect:/frontend/shopping-cart";
	}
}
