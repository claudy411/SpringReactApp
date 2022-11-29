package com.solera.bank.services;

import java.util.List;

import com.solera.bank.models.User;

public interface IUserService {

	public List<User> getAllUsers();
	
	public User getById(String id);
	
	public boolean createUser(User user);
	
	public void deleteUser(String id);
}
