package com.student.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.dao.QueryDao;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/loginpage", method = RequestMethod.POST)
	public String loginCheck(HttpServletRequest request, HttpServletResponse response, @RequestParam String username,
			@RequestParam String password) throws IOException {
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		boolean correctCredentials = false;
		correctCredentials = QueryDao.checkCredentials(username, password);
		if (correctCredentials)
			return "home";
		else {
			session.invalidate();
			return "login";
		}

	}
}
