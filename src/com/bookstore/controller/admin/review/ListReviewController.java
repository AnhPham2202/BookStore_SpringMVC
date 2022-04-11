package com.bookstore.controller.admin.review;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.service.ReviewService;

@Controller
@RequestMapping("/admin/")
public class ListReviewController {
	private String subfolder = "admin/review-pages/";
	@Autowired
	ReviewService reviewService;
	@GetMapping("list-review")
	public String showPage(HttpServletRequest request) {
		request.setAttribute("listReviews", reviewService.listAll());
		return subfolder + "list-review";
	}
}
