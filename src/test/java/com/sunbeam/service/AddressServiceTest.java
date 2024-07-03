package com.sunbeam.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sunbeam.dto.AddressDTO;
import com.sunbeam.dto.ApiResponse;

@SpringBootTest
class AddressServiceTest {

	@Autowired
	private AddressService addressService;

	@Test
	void testAssignUserAddress() {
		AddressDTO dto=new AddressDTO("line34", "line24", "Mumbai", "MH", "India", "456789", "778899123");
		ApiResponse response = addressService.assignUserAddress(1l,dto);
		assertTrue(response.getMessage().contains("Assigned"));
		
	}

}
