package com.bootPr.springBootRestfulServices.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bootPr.springBootRestfulServices.beans.User;

@Service
public class UserService {

	
	private static List<User> users = new ArrayList<>();
	static {
		
		users.add(new User(1L, "Mike", LocalDate.now()));
		users.add(new User(2L, "Muller", LocalDate.now()));
		users.add(new User(3L, "Samoan", LocalDate.of(1991, 11, 12)));
	}
	
	private static Long userCount = 3L;
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId() == null ) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(Long id) {
		return users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
	}
}
