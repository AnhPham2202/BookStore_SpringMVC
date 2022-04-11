package com.bookstore.controller.admin.category;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bookstore.entity.Category;
import com.bookstore.service.CategoryService;

@Controller
@RequestMapping(value = "/admin")
public class CreateCategoryController {
	private String subfoler = "admin/category-pages/";
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("create-category")
	public String getCategoryPage() {
		return subfoler + "create_category";
	}
	
	
	@PostMapping("create-category")
	public String createCategory(HttpServletRequest request, RedirectAttributes attribute) {
		Category createdCategory = categoryService.create(request, attribute);
		
		if (createdCategory == null) {
			return subfoler + "create_category";
		} else {			
			return "redirect:/admin/list-categories";
		}
		
	}
	
}
