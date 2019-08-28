package com.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.student.dao.QueryDao;
import com.student.service.ServiceClass;

@Controller
public class Register {
	
	@RequestMapping(value="/addinfo", method=RequestMethod.GET)
	public String showAddInfoPage() {
		return "addinfo";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addStudentClass(HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws ServletException, IOException {
		boolean invalidDetails;
		String name = request.getParameter("name");

		try {
			int age = Integer.parseInt(request.getParameter("age"));
			invalidDetails = ServiceClass.checkCharacter(name);
			invalidDetails = QueryDao.addStudent(name, age);;
		} catch (NumberFormatException e) {
			invalidDetails = true;
		}

		if (!invalidDetails && !name.equals("")) {
			model.addAttribute("message", "Record added to Database");
			return "result";

		} else {
			model.addAttribute("message", "Enter Valid Name or Age.");
			return "addinfo";
		}
	}
}
