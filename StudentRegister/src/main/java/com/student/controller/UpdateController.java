package com.student.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.student.dao.QueryDao;
import com.student.model.Student;
import com.student.service.ServiceClass;

@Controller
public class UpdateController {
	
	@RequestMapping(value="/updateinfo", method=RequestMethod.GET)
	public String showUpdateInfoPage() {
		return "updateinfo";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String changeData(HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws ServletException, IOException {
		boolean invalidDetails = false;
		String getName = request.getParameter("name");
		invalidDetails = ServiceClass.checkCharacter(getName);
		if (!invalidDetails && !getName.equals("")) {
			ArrayList<Student> studentList = ServiceClass.getDetailsByName(getName);
			if (studentList.isEmpty()) {
				model.addAttribute("message", "No Records Found with that Name.");
				return "updateinfo";
			} else
			model.addAttribute("student", studentList);
			return "modify";
		}
		
		model.addAttribute("message", "Enter Valid Name");
		return "updateinfo";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String updatedResult(HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws ServletException, IOException {

		boolean invalidDetails = false;
		long updateId = Long.parseLong(request.getParameter("update"));

		String updateName = request.getParameter("name");
		invalidDetails = ServiceClass.checkCharacter(updateName);
		if (!invalidDetails) {
			String updateAge = request.getParameter("age");

			invalidDetails = QueryDao.updateQueryOperation(updateId, updateAge, updateName);
		}

		if (!invalidDetails)
			model.addAttribute("message", "The Desired Record is Updated.");
		else
			model.addAttribute("message", "Enter Valid Details");

		return "result";

	}
}
