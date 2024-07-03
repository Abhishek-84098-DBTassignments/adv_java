package com.sunbeam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.AddressDTO;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Address;
import com.sunbeam.entities.User;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ApiResponse assignUserAddress(Long userId, AddressDTO dto) {
		// 1. get user from it's id
		User user = userDao.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Invalid user id !!!!"));
		// user : PERSISTENT
		// 2. map dto -> adr entity
		Address addressEntity = modelMapper.map(dto, Address.class);
		// 3. establish uni dir asso User 1--->1 Address
		user.setUserAddress(addressEntity);// modifying state persistent entity : user
		// no need of explicitly saving the address : thanks to cascadetType.ALL
		return new ApiResponse("Assigned user address....");
	}// commit | rollback

}
