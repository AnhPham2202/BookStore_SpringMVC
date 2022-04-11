package com.bookstore.service;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bookstore.dao.CustomerDAO;
import com.bookstore.entity.Customer;
import com.bookstore.utils.SecurityUtils;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDAO dao;
	
	@Autowired
	private SecurityUtils secUtils;
	
	public Customer getCustomerById(int id) {
		return dao.find(Customer.class, id);
	}
	
	public List<Customer> listCustomer() {
		return dao.listAllWithNamedQuery("listAllCustomer");
	}
	
	public Customer createCustomer(HttpServletRequest request) {
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullName");
		String password = request.getParameter("password");
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String zipCode = request.getParameter("zipCode");
		Date registerDate = new Date();
		
		String hashPassword = secUtils.hashPassword(password);
		
		if (getCustomerByEmail(request) != null) {
			return null;
		}
		Customer newCustomer = new Customer(email, fullName, address, city, country, phone, zipCode, hashPassword, registerDate);
		dao.create(newCustomer);
		return newCustomer;
	}
	
	public void updateCustomer(Customer customer, HttpServletRequest request) {
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullName");
		String password = request.getParameter("password");
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String zipCode = request.getParameter("zipCode");
		String hashPassword = secUtils.hashPassword(password);

		customer.setEmail(email);
		customer.setFullname(fullName);
		customer.setPassword(hashPassword);
		customer.setCountry(country);
		customer.setCity(city);
		customer.setAddress(address);
		customer.setZipcode(zipCode);
		customer.setPhone(phone);
		
		dao.update(customer);
	}
	
	public void deleteCustomer(int id) {
		dao.delete(Customer.class, id);
	}
	
	private Customer getCustomerByEmail(HttpServletRequest request) {
		String email = request.getParameter("email");
		return dao.findByField("findCustomerByEmail", "email", email);
	}
	
	public void logIn(HttpServletRequest request) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		session.removeAttribute("customer");
		Customer customer= dao.checkLogIn(email, password);
		if (customer != null) {
			session.setAttribute("customer", customer);
		} else {
			request.setAttribute("msg", "Email or password is incorrect !!!");
		}
	}
}
