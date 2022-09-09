package com.example.springbatch5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.springbatch5.models.User;
import com.example.springbatch5.services.UserService;

@RestController
@RequestMapping("/api")
public class ApiClient {
		
	 @Autowired
	    UserService service;
	 
	 
	    @GetMapping("/display")
		public List<User> showUserss (Model model) {
			return service.listUser();	
	    }
	    
	    @PostMapping("/save")
	    public ResponseEntity<Object> savedata(User user) {
	        service.save(user);
	        return new ResponseEntity<>("User is registered successfully", HttpStatus.CREATED);
	       
	    }
	    
	    @PutMapping("/edit/{id}")
		public ResponseEntity<Object> editData(@PathVariable(name="id") Integer id,User user) {
			service.get(id);
			service.save(user);
			return new ResponseEntity<>("User is updated successfully", HttpStatus.CREATED);
		}
	    

		@DeleteMapping("/delete/{id}")
		public ResponseEntity<Object> deleteData(@PathVariable(name="id") Integer id) {
			service.delete(id);
			return new ResponseEntity<>("Delete is updated successfully", HttpStatus.CREATED);
		}
		
		@GetMapping("/display/{id}")
		public User showUsers (@PathVariable(name="id") Integer id) {
			return service.get(id);	
	    }
		
}
