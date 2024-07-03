package com.sunbeam.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sunbeam.dto.UserDetails;
import com.sunbeam.entities.User;
//Unit test for testing a DAL layer method
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class TestUserDao {
	@Autowired
	private UserDao userDao;

	@Test //method level annotation to indicate that it's test method
	void testFindByEmailAndPassword() {
		User user = userDao.findByEmailAndPassword("a76@gmail.com",
				"1934")
				.get();
		//args - expected value n actual
		//test case passes iff - expected = actual
		assertEquals("a7", user.getFirstName());
	}
	@Test
	void testFindUsersByCity() {
		List<UserDetails> list = userDao.fetchUsersByCity("Pune");
		assertEquals(2, list.size());
		//for quick testing : NOT RECOMMENDED for unit test!!!
		System.out.println("user details - ");
		list.forEach(System.out::println);
	}

}
