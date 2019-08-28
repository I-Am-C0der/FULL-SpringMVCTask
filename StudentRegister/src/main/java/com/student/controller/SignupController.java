package com.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.student.dao.QueryDao;
import com.student.model.Users;

@Controller
class SignupController {

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String showSignUpPage() {
		return "signup";
	}

	@RequestMapping(value = "/signuppage", method = RequestMethod.POST)
	public String signupCheck(HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@ModelAttribute("userDetails") Users userDetails) throws ServletException, IOException {
		boolean invalidName = false;
		boolean usernamePresent = QueryDao.checkUsername(userDetails.getUsername());

		if (usernamePresent == true) {
			model.addAttribute("message", "Username Already Present");
			return "signup";

		} else {
			invalidName = QueryDao.signUp(userDetails.getName(), userDetails.getUsername(), userDetails.getEmail(),
					userDetails.getPassword());
			if (invalidName == true) {
				model.addAttribute("message", "Enter Valid Name");
				return "signup";
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("username", userDetails.getUsername());
				session.setAttribute("password", userDetails.getPassword());
				return "home";
			}
		}
	}

}
