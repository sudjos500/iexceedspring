package com.example.springbatch5.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbatch5.models.User;
import com.example.springbatch5.repo.UseRepository;

@Service
public class UserService {
	@Autowired
	UseRepository repo;
	public Object listUser;
	 
	public List<User> listUser(){
		return repo.findAll();
	}
	
	public void save(User user) {
		repo.save(user);
	}
	
	public User get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}

}
