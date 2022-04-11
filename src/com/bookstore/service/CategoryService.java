package com.bookstore.service;

import java.util.List;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryDAO dao;

	public List<Category> listAllCategories(HttpServletRequest request, HttpServletResponse response) {

		List<Category> listCategory = dao.listAllWithNamedQuery("listAllCategories");
		request.setAttribute("listCategories", listCategory);
		return listCategory;
	}

	public Category getCategoryById(int id) {
		Category category = dao.find(Category.class, id);
		return category;
	}

	public Category create(HttpServletRequest request, RedirectAttributes attribute) {
		String name = request.getParameter("name");
		Category dupCate = getCategoryByName(name);

		if (dupCate == null) {
			Category category = new Category(name);
			Category createdCategory = dao.create(category);
			sendMsgToReqWhenRedirect(attribute, "Create category successfully !!!");

			return createdCategory;
		} else {
			request.setAttribute("msg", "Already have this category !!!");
			return null;
		}
	}

	public Category update(HttpServletRequest request, int id) {
		String name = request.getParameter("name");
		Category category = dao.find(Category.class, id);
		Category dupCategory = getCategoryByName(name);

		if (dupCategory == null) {
			category.setName(name);
			dao.update(category);
			return dao.update(category);
		} else {
			if (dupCategory.getName().equals(category.getName())) {
				category.setName(name);
				dao.update(category);
				return dao.update(category);
			} else {
				return null;
			}
		}

	}
	
	public void deleteCategory(int id, RedirectAttributes attribute) {
			dao.delete(Category.class, id);
			attribute.addFlashAttribute("msg", "Delete category with id " + id + " successfully !!!");
	}

	public Category getCategoryByName(String name) {
		return dao.findByField("findByName", "name", name);
	}

	private void sendMsgToReqWhenRedirect(RedirectAttributes attribute, String msg) {
		attribute.addFlashAttribute("msg", msg);
	}
}
