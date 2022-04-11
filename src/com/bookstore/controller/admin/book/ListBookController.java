package com.bookstore.controller.admin.book;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.entity.Book;
import com.bookstore.service.BookService;

@Controller
@RequestMapping(value = "/admin/")
public class ListBookController {
	
	@Autowired
	BookService bookService;
	
	String subfolder = "admin/book-pages/";
	
	@GetMapping("list-books")
	public String showPage(HttpServletRequest request) {
		List<Book> listBooks = bookService.listAllBook();
		request.setAttribute("listBooks", listBooks);
		return subfolder + "list_books";
	}
}
