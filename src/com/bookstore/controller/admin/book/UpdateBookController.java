package com.bookstore.controller.admin.book;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bookstore.entity.Book;
import com.bookstore.service.BookService;

@Controller
@RequestMapping(value = "/admin/")
public class UpdateBookController {
	String subfolder = "admin/book-pages/";

	@Autowired
	BookService bookService;
	
	@GetMapping("update-book/{id}")
	public String showPage(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) {
		bookService.getCategory(request, response);
		Book book = bookService.getBookFromId(id);
		request.setAttribute("book", book);
		return subfolder + "update_book";
	}
	
	@PostMapping("update-book/{id}")
	public String updateBook(@PathVariable("id") int id, HttpServletRequest request, @RequestParam("book-img") MultipartFile file) throws IOException, ServletException, ParseException {
		bookService.updateBook(request, file, id);
		return "redirect:/admin/list-books";
	}
	
}
