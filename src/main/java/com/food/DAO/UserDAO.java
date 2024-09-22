package com.food.DAO;

import java.util.List;

import com.food.model.User;

public interface UserDAO {
	boolean addUser(User user);
	User getUser(int userID);
	void updateUser(User user);
	void deleteUser(int userID);
	List<User> getAllUsers();
	User validateUser(String username, String password);
}
