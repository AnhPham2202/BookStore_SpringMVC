package com.bookstore.controller.frontend.shoppingCart;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bookstore.entity.ShoppingCart;
import com.bookstore.service.ShoppingCartService;


@Controller
@RequestMapping("/frontend/")
public class PlaceOrderController {
	String subfolder = "frontend/shopping-cart/";
	
	@Autowired
	ShoppingCartService shoppingCartService;
	
	@PostMapping("shopping-cart/place-order")
	public String placeOrder(HttpServletRequest request, RedirectAttributes redirect) {
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");

		if (cart.getItems().isEmpty()) {
			redirect.addFlashAttribute("msg", "You are not having any book in your cart!!!");
			return "redirect:/frontend/shopping-cart";
		}
		
		shoppingCartService.createOrder(request);
		return subfolder + "place-order-done";
	}
}
