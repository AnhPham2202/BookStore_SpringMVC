package com.bookstore.controller.admin.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bookstore.service.BookService;

@Controller
@RequestMapping(value = "/admin/")
public class DeleteBookController {
	
	@Autowired
	BookService bookService;
	
	@PostMapping("delete-book/{id}")
	public String deleteBook(@PathVariable("id") int id, RedirectAttributes attribute) {
		bookService.deleteBook(id);
		attribute.addFlashAttribute("msg", "Detele book successfully !!!");
		return "redirect:/admin/list-books";
	}
}
