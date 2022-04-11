package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bookstore.dao.UserDao;
import com.bookstore.entity.Users;
import com.bookstore.utils.SecurityUtils;

@Transactional
@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	@Autowired
	private SecurityUtils secUtils;
	
	public UserService() {
	}

	public void listUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Users> listUsers = dao.listAll();
		request.setAttribute("listUsers", listUsers);

	}

	public void create(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullName");
		String password = request.getParameter("password");
		String hashPassword = secUtils.hashPassword(password);
		Users user = new Users(email, hashPassword, fullName);
		dao.create(user);

	}

	public void updateUser(HttpServletRequest request, HttpServletResponse response, int id) {
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullName");
		String password = request.getParameter("password");

		Users userNeedToUpdate = dao.find(Users.class, id);
		String hashPassword = secUtils.hashPassword(password);

		userNeedToUpdate.setEmail(email);
		userNeedToUpdate.setFullName(fullName);
		userNeedToUpdate.setPassword(hashPassword);

		dao.update(userNeedToUpdate);

	}

	public Users findByEmail(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		Users existUser = dao.findUserByEmail(email);

		if (existUser != null) {
			return existUser;
		} else {
			return null;
		}
	}

	public Users findById(HttpServletRequest request, HttpServletResponse response, int id) {
		Users user = dao.find(Users.class, id);
		if (user == null) {
			request.setAttribute("msg", "There's no user with this id");
			return null;
		} else {
			request.setAttribute("user", user);
			return user;
		}
	}
	
	public void deleteUserById(HttpServletRequest request, HttpServletResponse response, int id) {
		Users user = dao.find(Users.class, id);
		
		dao.delete(Users.class, user.getUserId());
	}
	
	
	public void logIn(HttpServletRequest request) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		boolean loggedIn = dao.checkLogIn(email, password);
		if (loggedIn == true) {
			session.setAttribute("user", email);
		} else {
			request.setAttribute("msg", "Email or password is incorrect !!!");
		}
	}
	
	
	public void sendMsgToReqWhenRedirect(RedirectAttributes attribute, String attributeName, String msg) {
		attribute.addFlashAttribute(attributeName, msg);
	}

}
