package com.solera.bank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.solera.bank.models.User;
import com.solera.bank.repo.IUserRepo;

@Service
public class UserService implements IUserService {
	
	@Autowired
	IUserRepo repo;

	@Override
	public List<User> getAllUsers() {

		return repo.findAll();
	}

	@Override
	public User getById(String id) {

		return repo.findById(id).orElse(null);
	}

	@Override
	public boolean createUser(User user) {

		repo.save(user);
		return true;
	}

	@Override
	public void deleteUser(String id) {

		repo.deleteById(id);
	}

}
