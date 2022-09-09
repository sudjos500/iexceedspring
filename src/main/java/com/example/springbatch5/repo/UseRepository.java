package com.example.springbatch5.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.springbatch5.models.User;

public interface UseRepository extends JpaRepository<User,Integer>{
	@Query("select u from User u where u.email = :email")
	public User getUserByUserName(@Param("email") String email);

}
