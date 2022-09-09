package com.example.springbatch5.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbatch5.models.Contact;

import com.example.springbatch5.repo.ContactRepository;

@Service
public class ContactService {
	@Autowired
	ContactRepository repo;
	
	public List<Contact> listContact(){
		return repo.findAll();
	}
	
	public void save(Contact contact) {
		repo.save(contact);
	}
	
	public Contact get(Integer cId) {
		return repo.findById(cId).get();
	}
	
	public void delete(Integer cId) {
		repo.deleteById(cId);
	}


}
