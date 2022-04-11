package com.bookstore.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookstore.entity.Users;
import com.bookstore.service.UserService;

@Controller
@RequestMapping("")
public class SignUpAdminController {
	
	String subfolder = "admin/";
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	public String CreateAndRedirectToListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Users user = userService.findByEmail(request, response);
		if (user == null) {
			userService.create(request, response);
			userService.listUsers(request, response);
			return "redirect:/admin";
		} else {
			request.setAttribute("msg",  "Email is already existed");
			return subfolder + "sign-up";
		}
		
		
	}
	
	
	@RequestMapping(value = "/sign-up", method = RequestMethod.GET)
	public String showPage() {
		return subfolder + "sign-up";

	}
}
