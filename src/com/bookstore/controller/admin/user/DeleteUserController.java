package com.bookstore.controller.admin.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bookstore.service.UserService;

@Controller
@RequestMapping(value = "/admin/")
public class DeleteUserController {
	String subfolder = "admin/user-pages/";

	@Autowired
	private UserService userService;

	@PostMapping("delete_user/{id}")
	public String deleteUser(
			@PathVariable("id") int id, 
			RedirectAttributes attribute, 
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		userService.deleteUserById(request, response, id);
		userService.sendMsgToReqWhenRedirect(attribute, "msg", "Delete successfully !!!");
		return "redirect:/admin/list_users";
	}
}
