package com.bookstore.controller.frontend;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import com.bookstore.service.BookService;
import com.bookstore.service.CategoryService;

@Controller
@RequestMapping("/frontend/view-category")
public class ViewCategory {
	String subfolder = "frontend/";
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private BookService bookService;
	
	@GetMapping("")
	public String showPage(@RequestParam int id, HttpServletRequest request, HttpServletResponse response) {
		categoryService.listAllCategories(request, response);
		Category category = categoryService.getCategoryById(id);
		List<Book> listBooksByCategory = bookService.getBookByCategory(id);
		request.setAttribute("categoryName", category.getName());
		request.setAttribute("books", listBooksByCategory);
		return subfolder +  "view-category";
	}
	
//	@GetMapping("")
//	public String showDetailCate() {
//		getBooksByCategory
//	}
}
