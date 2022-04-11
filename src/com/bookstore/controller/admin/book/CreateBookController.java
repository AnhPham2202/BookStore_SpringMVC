package com.bookstore.controller.admin.book;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bookstore.entity.Book;
import com.bookstore.service.BookService;

@Controller
@RequestMapping(value = "/admin/")
public class CreateBookController {
	String subfolder = "admin/book-pages/";
	@Autowired
	BookService bookService;
	
	@GetMapping("create-book")
	public String showPage(HttpServletRequest request, HttpServletResponse response) {
		bookService.getCategory(request, response);
		return subfolder + "create_book";
	}
	
	@PostMapping("create-book")
	public String createBook(HttpServletRequest request, RedirectAttributes redirect, @RequestParam("book-img") MultipartFile file) throws IOException, ServletException, ParseException {
		Book newBook = bookService.createBook(request, file);
		redirect.addFlashAttribute("msg", "Create book with id " + newBook.getBookId() + " successfully !!!");

		return "redirect:/admin/list-books";
	}
}
