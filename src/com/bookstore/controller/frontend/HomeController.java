package com.bookstore.controller.frontend;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.entity.Book;
import com.bookstore.service.BookService;
import com.bookstore.service.CategoryService;

@Controller
@RequestMapping("/frontend")
public class HomeController {
	String subfolder = "frontend/";
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	BookService bookService;
	
	@GetMapping
	public String showPage(HttpServletRequest request, HttpServletResponse response) {
		List<Book> listBook = bookService.getNewestBooks();
		List<Book> listBestSeller = bookService.getBestSeller();
		List<Book> listFavored = bookService.getBestFavored();
		request.setAttribute("books", listBook);
		request.setAttribute("bestSellerBooks", listBestSeller);
		request.setAttribute("bestFavored", listFavored);
		categoryService.listAllCategories(request, response);
		return subfolder + "home";
	}
}
