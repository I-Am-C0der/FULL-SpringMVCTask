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
public class RemoveController {

	@RequestMapping(value = "/removeinfo", method = RequestMethod.GET)
	public String showRemovePage() {
		return "removeinfo";
	}

	@RequestMapping(value = "/deregister", method = RequestMethod.GET)
	protected String removeData(HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws ServletException, IOException {
		boolean invalidDetails = false;
		String getName = request.getParameter("name");
		invalidDetails = ServiceClass.checkCharacter(getName);
		if (!invalidDetails && !getName.equals("")) {
			ArrayList<Student> studentList = ServiceClass.getDetailsByName(getName);
			if (studentList.isEmpty()) {
				model.addAttribute("message", "No Records Found with that Name.");
				return "removeinfo";
			} else
			model.addAttribute("student", studentList);
			return "deregister";
		}
		
		model.addAttribute("message", "Enter Valid Name");
		return "removeinfo";

	}

	@RequestMapping(value = "/deregister", method = RequestMethod.POST)
	protected String removeResult(HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws ServletException, IOException {

		long removeId = Long.parseLong(request.getParameter("remove"));
		QueryDao.removeByIdQuery(removeId);

		model.addAttribute("message", "Desired Record is removed.");
		return "result";

	}
}
