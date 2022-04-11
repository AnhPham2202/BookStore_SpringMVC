package com.bookstore.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.dao.ReviewDAO;
import com.bookstore.entity.Review;

@Service
public class ReviewService {
	
	@Autowired
	ReviewDAO dao;
	
	public List<Review> listAll() {
		return dao.listAllWithNamedQuery("listAllReivew");
	}
	
	public Review createReview(Review review) {
		return dao.create(review);
	}
	
	public List<Review> getAllReviewByBookId(int bookId) {
		Map<String, Object> paramList = new HashMap<String, Object>();
		paramList.put("bookId", bookId);
		return (List<Review>) dao.queryWithManyParamsListResult("getAllReviewByBookId", paramList);
	}
	
	public void deleteReviewById(int id) {
		dao.delete(Review.class, id);
	}
} 
