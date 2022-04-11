package com.bookstore.controller.admin.category;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bookstore.service.CategoryService;

@Controller
@RequestMapping(value = "/admin/")
public class DeleteCategoryController {

	@Autowired
	CategoryService categoryService;
	
	@PostMapping("delete-category/{id}")
	public String deleteCategory(
			@PathVariable("id") int id, 
			RedirectAttributes attribute) {
		categoryService.deleteCategory(id, attribute);
		
		return "redirect:/admin/list-categories";
	}
}
