package com.student.dao;

import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.student.service.ServiceClass;

public class QueryDao {
	static DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	static Query queryStudent = new Query("Student");
	static PreparedQuery preparedQuery = datastore.prepare(queryStudent);
	static Query queryUser = new Query("Users");
	static PreparedQuery preparedQueryLogin = datastore.prepare(queryUser);

	public static boolean updateQueryOperation(long updateId, String updateAge, String updateName) {
		boolean invalidId = false;

		int check = 0;
		for (Entity entity : preparedQuery.asIterable()) {
			long getId = entity.getKey().getId();
			if (updateId == getId) {
				check = 1;
				if (!updateName.equals(""))
					entity.setProperty("Name", updateName);
				if (!updateAge.equals("")) {
					int updateAgeNumber = Integer.parseInt(updateAge);
					entity.setProperty("Age", updateAgeNumber);
				}
				datastore.put(entity);
				break;
			}
		}
		if (check == 0)
			invalidId = true;
		return invalidId;
	}

	public static void removeByIdQuery(long removeId) {
		for (Entity entity : preparedQuery.asIterable()) {
			long getId = entity.getKey().getId();
			if (removeId == getId) {
				datastore.delete(entity.getKey());
				break;
			}
		}

	}

	public static boolean removeAllQuery() {
		boolean removeAll = true;
		for (Entity entity : preparedQuery.asIterable()) {
			datastore.delete(entity.getKey());
		}
		return removeAll;
	}

	public static boolean checkUsername(String username) {
		boolean usernamePresent = false;
		for (Entity entity : preparedQueryLogin.asIterable()) {
			String getUsername = (String) entity.getProperty("Username");
			if (getUsername.equals(username)) {
				usernamePresent = true;
				break;
			}
		}
		return usernamePresent;
	}

	public static boolean checkCredentials(String username, String password) {
		boolean correctCredentials = false;
		for (Entity entity : preparedQueryLogin.asIterable()) {
			if (entity.getProperty("Username").equals(username) && entity.getProperty("Password").equals(password)) {
				correctCredentials = true;
			}
		}

		return correctCredentials;
	}

	public static List<Entity> getDetails() {

		List<Entity> results = preparedQuery.asList(FetchOptions.Builder.withDefaults());
		return results;
	}

	public static boolean addStudent(String name, int age) {
		boolean invalidDetails = false;

		invalidDetails = ServiceClass.checkCharacter(name);
		if (!invalidDetails) {
			Entity entity = new Entity("Student");
			entity.setProperty("Name", name);
			entity.setProperty("Age", age);
			datastore.put(entity);
		}

		return invalidDetails;

	}

	public static boolean signUp(String name, String username, String email, String password) {
		boolean invalidName = false;

		invalidName = ServiceClass.checkCharacter(name);
		if (!invalidName) {
			Entity entity = new Entity("Users");
			entity.setProperty("Name", name);
			entity.setProperty("Username", username);
			entity.setProperty("Email", email);
			entity.setProperty("Password", password);
			datastore.put(entity);
		}

		return invalidName;

	}
}
