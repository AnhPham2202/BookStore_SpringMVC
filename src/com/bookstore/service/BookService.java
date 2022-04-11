package com.bookstore.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bookstore.dao.BookDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import com.bookstore.entity.Review;

@Service
public class BookService {
	@Autowired
	private BookDAO dao;
	
	@Autowired
	private CategoryService categoryService;
	
	public List<Category> getCategory(HttpServletRequest request, HttpServletResponse response) {
		return categoryService.listAllCategories(request, response);
	}
	
	public List<Book> listAllBook () {
		List<Book> listBooks = dao.listAllWithNamedQuery("getAllBooks");
		Book book = dao.find(Book.class, listBooks.get(0).getBookId());
		System.out.println(book.getImage());
		return listBooks;
	}
	
	public Book createBook(HttpServletRequest request, MultipartFile file) throws IOException, ServletException, ParseException {
		DateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");

		int categoryId = Integer.parseInt(request.getParameter("category"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String isbn = request.getParameter("isbn");
		float price = Float.parseFloat(request.getParameter("price"));
		String description = request.getParameter("description");
		Date publishDate = dateFormatter.parse(request.getParameter("publish-date"));
		
		byte[] imgBytes = new byte[(int) file.getSize()];
		InputStream inputStream =  file.getInputStream();
		inputStream.read(imgBytes);
		inputStream.close();	
		
		Book book = new Book();
		
		Category category = categoryService.getCategoryById(categoryId);
		
		book.setCategory(category);
		book.setAuthor(author);
		book.setDescription(description);
		book.setImage(imgBytes);
		book.setIsbn(isbn);
		book.setPrice(price);
		book.setPublishDate(publishDate);
		book.setLastUpdateTime(publishDate);		
		book.setTitle(title);

		dao.create(book);
		return book;
	}
	
	public Book updateBook(HttpServletRequest request, MultipartFile file, int id) throws IOException, ServletException, ParseException {
		Book bookUpdate = dao.find(Book.class, id);
		
		DateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");

		int categoryId = Integer.parseInt(request.getParameter("category"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String isbn = request.getParameter("isbn");
		float price = Float.parseFloat(request.getParameter("price"));
		String description = request.getParameter("description");
		Date publishDate = dateFormatter.parse(request.getParameter("publish-date"));
		Category category = categoryService.getCategoryById(categoryId);
		
		if (file.getSize() != 0) {
			byte[] imgBytes = new byte[(int) file.getSize()];
			InputStream inputStream =  file.getInputStream();
			inputStream.read(imgBytes);
			inputStream.close();	
			bookUpdate.setImage(imgBytes);
		} 
		bookUpdate.setCategory(category);
		bookUpdate.setAuthor(author);
		bookUpdate.setDescription(description);
		bookUpdate.setIsbn(isbn);
		bookUpdate.setPrice(price);
		bookUpdate.setPublishDate(publishDate);
		bookUpdate.setLastUpdateTime(publishDate);		
		bookUpdate.setTitle(title);

		dao.update(bookUpdate);
		return bookUpdate;
	}
	
	public List<Book> getBookByCategory(int categoryId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("categoryId", categoryId);
		List<Book> listBooksByCategory = (List<Book>) dao.queryWithManyParamsListResult("getBooksByCategory", params);
		return listBooksByCategory;
	}
	
	public void deleteBook (int id) {
		dao.delete(Book.class, id);
	}
	
	public Book getBookFromId(int id) {
		return dao.find(Book.class, id);
	}
	
	public List<Book> search(String keyword) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keyword", keyword);
		List<Book> listBook = (List<Book>) dao.queryWithManyParamsListResult("searchBook", params);
		return listBook;
	}
	
	public List<Book> getBestSeller() {
		return dao.querySingleParamsWithLimitedRecord("listTop5BestSellerBooks", null, null, 4);
	}
	
	public List<Book> getBestFavored() {
		return dao.querySingleParamsWithLimitedRecord("listTopFavoredBooks", null, null, 4);
	}
	
	
	public List<Book> getNewestBooks() {
		return dao.querySingleParamsWithLimitedRecord("listBooksOrderByPublishDate", null, null, 4);
	}

}
