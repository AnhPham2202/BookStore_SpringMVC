package com.bookstore.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.entity.Users;

@Controller
@RequestMapping(value = "/admin")
public class HomeAdminController {
	String subfolder = "admin/";
	
	@RequestMapping(value="")
	public String showHomeAdminPage(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		Users user = (Users) session.getAttribute("user");
//		if (user != null) {
//			session.setAttribute("user", user);
//		}
		return subfolder + "index";
	}
	
}
