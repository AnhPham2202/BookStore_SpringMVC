package com.bookstore.controller.admin.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookstore.service.ReviewService;

@Controller
@RequestMapping(value = "/admin/")
public class RemoveReviewController {
	@Autowired
	ReviewService reviewService;
	
	@PostMapping("remove-review")
	public String removeReview(@RequestParam int id) {
		reviewService.deleteReviewById(id);
		return "redirect:/admin/list-review";
	}

}
