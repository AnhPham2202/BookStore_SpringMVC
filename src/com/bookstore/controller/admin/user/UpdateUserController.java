package com.bookstore.controller.admin.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bookstore.entity.Users;
import com.bookstore.service.UserService;

@Controller
@RequestMapping(value = "/admin/")
public class UpdateUserController {
	String subfolder = "admin/user-pages/";

	@Autowired
	private UserService userService;

	@GetMapping("update_user/{id}")
	public String showUpdatePage(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) {
		userService.findById(request, response, id);
		return subfolder + "update_user";
	}

	// cần enhance update nếu k thay đổi email sẽ k update đc 
	
	@PostMapping("update_user/{id}")
	public String updateUser(@PathVariable("id") int id, 
							RedirectAttributes attribute,
							HttpServletRequest request, 
							HttpServletResponse response)
			throws ServletException, IOException {
		Users dupUser = userService.findByEmail(request, response);
		Users user = userService.findById(request, response, id);

		if (dupUser != null) {
			request.setAttribute("msg", "Email already exists !!!");

			return subfolder + "update_user";
		} else {
			userService.updateUser(request, response, id);
			userService.listUsers(request, response);
			userService.sendMsgToReqWhenRedirect(attribute, "msg", "Update user successfully !!!");

			return "redirect:/admin/list_users";
		}
	}

}
