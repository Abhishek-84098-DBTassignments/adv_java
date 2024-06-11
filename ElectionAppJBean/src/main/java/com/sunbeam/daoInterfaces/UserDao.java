package com.sunbeam.daoInterfaces;

import com.sunbeam.entities.User;

public interface UserDao extends AutoCloseable {
	User findByEmail(String email) throws Exception;

	User findById(int id) throws Exception;

	int save(User user) throws Exception;

	int updateStatus(int userId, boolean voted) throws Exception;

	int updatePassword(int userId, String newPassword) throws Exception;

	int deleteById(int id) throws Exception;

	int update(User user) throws Exception;
	
	public User finduser(String email,String passw) throws Exception;
}
