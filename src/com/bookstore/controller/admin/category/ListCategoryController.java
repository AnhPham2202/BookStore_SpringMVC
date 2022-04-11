package com.bookstore.controller.admin.category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.service.CategoryService;

@Controller
@RequestMapping(value = "/admin")
public class ListCategoryController {
	String subfoler = "admin/category-pages/";
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/list-categories")
	public String listCategories (HttpServletRequest request, HttpServletResponse response) {
		
		categoryService.listAllCategories(request, response);
		
		return subfoler + "list-categories";
	}

}
