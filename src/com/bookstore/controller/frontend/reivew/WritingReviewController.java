package com.bookstore.controller.frontend.reivew;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookstore.entity.Book;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Review;
import com.bookstore.service.BookService;
import com.bookstore.service.ReviewService;

@Controller
@RequestMapping("/frontend/")
public class WritingReviewController {
	String subfolder = "frontend/review-pages/";
	
	@Autowired
	BookService bookService;
	
	@Autowired
	ReviewService reviewService;
	
	@GetMapping("review")
	public String showPage(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("book", bookService.getBookFromId(id));
		return subfolder + "review-book";
	}
	
	@PostMapping("review")
	public String reviewBook(@RequestParam int id, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Book book = bookService.getBookFromId(id);
		String headline = request.getParameter("headline");
		String comment = request.getParameter("comment");
		int rating = Integer.parseInt(request.getParameter("rating"));
		Customer customer = (Customer) session.getAttribute("customer");
		Review review = new Review(book, customer, rating, headline, comment, new Date());
		
		reviewService.createReview(review);
		return "redirect:/frontend/view-detail?id=" + id; 
	}

}
