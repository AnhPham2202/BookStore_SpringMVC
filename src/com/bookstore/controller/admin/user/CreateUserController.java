package com.bookstore.controller.admin.user;

import java.io.IOException;
import java.util.List;

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
@RequestMapping("/admin")
public class CreateUserController {
	
	String subfolder = "admin/user-pages/";
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/create_user", method = RequestMethod.POST)
	public String CreateAndRedirectToListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Users user = userService.findByEmail(request, response);
		if (user == null) {
			userService.create(request, response);
			userService.listUsers(request, response);
			return "redirect:list_users";
		} else {
			request.setAttribute("msg", "Email is already existed");
			return subfolder + "create_user";
		}
		
		
	}
	
	
	@RequestMapping(value = "/create_user", method = RequestMethod.GET)
	public String RedirectToList() {
		return subfolder + "create_user";

	}
}

