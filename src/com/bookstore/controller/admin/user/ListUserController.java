package com.bookstore.controller.admin.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.service.UserService;



@Controller
@RequestMapping("/admin")
public class ListUserController {
	String subfolder = "admin/user-pages/";

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/list_users")
	public String listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userService.listUsers(request, response);
		return subfolder + "list_users";
	}
}
