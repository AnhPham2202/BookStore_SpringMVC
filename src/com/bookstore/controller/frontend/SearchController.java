package com.bookstore.controller.frontend;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookstore.entity.Book;
import com.bookstore.service.BookService;

@Controller
@RequestMapping("/frontend/search")
public class SearchController {
	String subfolder = "frontend/";
	
	@Autowired
	BookService bookService;
	
	@GetMapping("")
	public String showPage() {
		return subfolder + "search-page";
	}
	
	@PostMapping("")
	public String showPage(@RequestParam String keyword, HttpServletRequest request) {
		List<Book> listBook = bookService.search(keyword);

		if (listBook.size() != 0) {
			request.setAttribute("searchResult", "Search results for " + keyword);
			request.setAttribute("listBook", listBook);			
		} else {
			request.setAttribute("searchResult", "No record found");
		}
		return subfolder + "search-page";
	}
	

}
