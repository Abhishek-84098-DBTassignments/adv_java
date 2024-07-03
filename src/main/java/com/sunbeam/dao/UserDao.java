package com.sunbeam.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.dto.UserDetails;
import com.sunbeam.entities.User;

public interface UserDao extends JpaRepository<User,Long>{
//add derived finder method for user signin 
	Optional<User> findByEmailAndPassword(String email,String pass);
	//Get all users(first name , last name , dob reg amount ) by city - unit test
//	@Query("select u from User u join u.userAddress  a where a.city=:city")
//	@Query("select new com.sunbeam.entities.User(firstName,lastName,dob,regAmount)  from User u join u.userAddress  a where a.city=:city")
	@Query("select new com.sunbeam.dto.UserDetails(firstName,lastName,dob,regAmount) from User u  where u.userAddress.city=:city")
	List<UserDetails> fetchUsersByCity(String city);
}
