package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Entity.RolesEntity;
import com.example.demo.Entity.User;

public interface UsersService {
	
	User saveUser(User user);
	List<User> getAllUser();
	User getUserById(long id);
	User updateUser(User user, long id);
	void deleteUser(long id);
	
	 
}
