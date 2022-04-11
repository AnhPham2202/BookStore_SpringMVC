package com.bookstore.controller.admin.category;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bookstore.entity.Category;
import com.bookstore.service.CategoryService;

@Controller
@RequestMapping(value = "/admin")
public class UpdateCategoryController {
	private String subfolder = "admin/category-pages/";

	@Autowired
	CategoryService categoryService;

	@GetMapping("update-category/{id}")
	public String showUpdatePage(@PathVariable("id") int id, HttpServletRequest request) {
		Category category = categoryService.getCategoryById(id);
		request.setAttribute("category", category);
		return subfolder + "update-category";
	}

	@PostMapping("update-category/{id}")
	public String updateCategory(@PathVariable("id") int id, HttpServletRequest request, RedirectAttributes attribute) {
		Category updatedCategory = categoryService.update(request, id);
		
		if (updatedCategory == null) {
			request.setAttribute("msg", "Already have this category !!!");
			return subfolder + "update-category";
		} else {			
			attribute.addFlashAttribute("msg", "Update category successfully !!!");
			return "redirect:/admin/list-categories";
		}

	}
}
