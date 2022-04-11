package com.bookstore.controller.frontend.shoppingCart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.entity.ShoppingCart;

@Controller
@RequestMapping("/frontend/")
public class ClearCartController {
	@GetMapping("shopping-cart/clear")
	public String showPage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		cart.clear();
		return "redirect:/frontend/shopping-cart";
	}
}
