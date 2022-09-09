package com.example.springbatch5.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbatch5.models.Contact;


public interface ContactRepository extends JpaRepository<Contact,Integer>{

}
