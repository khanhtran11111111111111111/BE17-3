package com.example.demo.Service.IMPL;


import java.util.Date;
import java.util.List;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.example.demo.Entity.User;
import com.example.demo.Repository.RolesRepository;
import com.example.demo.Repository.UsersRepository;
import com.example.demo.Service.UsersService;
import com.example.demo.exception.ResourceNotFoundException;


@Service
public class UsersServiceimpl implements UsersService{
	private UsersRepository usersRepository;

	public UsersServiceimpl(UsersRepository usersRepository) {
		super();
		this.usersRepository=usersRepository;
	}
	
	@Override
	public User saveUser(User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setIs_delete(false);
		user.setCreated_date(new Date());
		return usersRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return usersRepository.findAll();
	}
	@Override
	public User getUserById(long id) {
		return usersRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "Id", id));
	}
	@Override
	public User updateUser(User user, long id) {
		User existingUser=usersRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "Id", id));
		existingUser.setFullname(user.getFullname());
		existingUser.setAddress(user.getAddress());
		existingUser.setEmail(user.getemail());
		existingUser.setBirth(user.getBirth());
		existingUser.setPhone(user.getPhone());
		existingUser.setSex(user.getSex());
		existingUser.setUsername(user.getusername());
		existingUser.setPassword(user.getPassword());
	
		existingUser.setUpdate_date(new Date());
		
		
		//save toDB
		usersRepository.save(existingUser);
		
		return existingUser;
	}
	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		usersRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "Id", id));
		usersRepository.deleteById(id);
	}

	

}
