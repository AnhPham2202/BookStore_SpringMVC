package com.bookstore.controller.frontend;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookstore.service.BookService;
import com.bookstore.service.ReviewService;

@Controller
@RequestMapping("/frontend/view-detail")
public class ViewBookDetailController {
	String subfolder = "frontend/";
	
	@Autowired
	BookService bookService;
	
	@Autowired
	ReviewService reviewService;
	
	@GetMapping
	public String showPage(
			@RequestParam int id, 
			HttpServletRequest request) {
		request.setAttribute("reviews", reviewService.getAllReviewByBookId(id));
		request.setAttribute("book", bookService.getBookFromId(id));
		return subfolder + "view-book";
	}
}
