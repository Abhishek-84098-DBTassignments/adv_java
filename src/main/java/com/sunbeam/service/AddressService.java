package com.sunbeam.service;

import com.sunbeam.dto.AddressDTO;
import com.sunbeam.dto.ApiResponse;

public interface AddressService {
	ApiResponse assignUserAddress(Long userId, AddressDTO dto);
}
