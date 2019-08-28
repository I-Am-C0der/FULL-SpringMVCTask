package com.student.service;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.Entity;
import com.student.dao.QueryDao;
import com.student.model.Student;

public class ServiceClass {
	public static ArrayList<Student> getDetailsByName(String getName) {
		ArrayList<Student> studentList = new ArrayList<>();
		List<Entity> results = QueryDao.getDetails();
		for (Entity entity : results) {
			long id = entity.getKey().getId();
			String name = entity.getProperty("Name").toString();
			int age = Integer.parseInt(entity.getProperty("Age").toString());
			if (name.equalsIgnoreCase(getName)) {
				Student student = new Student(id, name, age);
				studentList.add(student);
			}
		}
		return studentList;

	}

	public static ArrayList<Student> getAllDetails() {
		ArrayList<Student> studentList = new ArrayList<>();
		List<Entity> results = QueryDao.getDetails();
		for (Entity entity : results) {
			long id = entity.getKey().getId();
			String name = entity.getProperty("Name").toString();
			int age = Integer.parseInt(entity.getProperty("Age").toString());
			Student student = new Student(id, name, age);
			studentList.add(student);
		}
		return studentList;

	}

	public static ArrayList<Student> getDetailsByAge(int getAge, int filterOption) {
		ArrayList<Student> studentList = new ArrayList<>();
		List<Entity> results = QueryDao.getDetails();
		for (Entity entity : results) {
			long id = entity.getKey().getId();
			String name = entity.getProperty("Name").toString();
			int age = Integer.parseInt(entity.getProperty("Age").toString());
			if (filterOption == 3) {
				if (age == getAge) {
					Student student = new Student(id, name, age);
					studentList.add(student);
				}
			} else if (filterOption == 2) {
				if (age < getAge) {
					Student student = new Student(id, name, age);
					studentList.add(student);
				}
			} else {
				if (age > getAge) {
					Student student = new Student(id, name, age);
					studentList.add(student);

				}
			}
		}
		return studentList;

	}

	public static boolean checkCharacter(String name) {
		boolean invalidDetails = false;
		boolean checkAllLettersAreCharacter = name.chars().allMatch(Character::isLetter);
		if (!checkAllLettersAreCharacter) {
			invalidDetails = true;
		}
		return invalidDetails;
	}
}
