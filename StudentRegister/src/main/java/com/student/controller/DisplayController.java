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

import com.student.model.Student;
import com.student.service.ServiceClass;

@Controller
public class DisplayController {
	
	@RequestMapping(value = "/displayinfo", method = RequestMethod.GET)
	public String showDisplayPage() {
		return "displayinfo";
	}
	
	@RequestMapping(value = "/display", method = RequestMethod.GET)
	protected String displayDetails(HttpServletRequest request, HttpServletResponse response,ModelMap model)
			throws ServletException, IOException {

		ArrayList<Student> studentList=null;
		String getName = request.getParameter("name");
		boolean invalidDetails = ServiceClass.checkCharacter(getName);
		if (request.getParameter("display") == null) {
			model.addAttribute("message","Choose a valid option.");
			return "displayinfo";

		} else if (Integer.parseInt(request.getParameter("display")) == 2 && getName.equals("") || invalidDetails) {

			model.addAttribute("message","Enter Valid Name.");
			return "displayinfo";

		} else {

			int displayOption = Integer.parseInt(request.getParameter("display"));
			switch (displayOption) {
			case 3:

				studentList = ServiceClass.getAllDetails();
				break;
			case 2:

				studentList = ServiceClass.getDetailsByName(getName);
				break;
			case 1:

				try {
					int getAge = Integer.parseInt(request.getParameter("age"));
					if (request.getParameter("filter") == null) {
						model.addAttribute("message","Choose a valid option.");
						return "displayinfo";

					} else {
						int filterOption = Integer.parseInt(request.getParameter("filter"));
						studentList = ServiceClass.getDetailsByAge(getAge, filterOption);

					}
				} catch (NumberFormatException e) {
					model.addAttribute("message","Enter Valid Age");
					return "displayinfo";
				}

			}
			
		}
		model.addAttribute("student", studentList);
		return "display";
	}
}

