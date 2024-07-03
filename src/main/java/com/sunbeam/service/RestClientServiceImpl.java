package com.sunbeam.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sunbeam.dto.DataDto;

@Service
public class RestClientServiceImpl implements RestClientService {
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${get.url}")
	private String getURL;

	@Override
	public DataDto getData(int id) {
		/*
		 * public <T> T getForObject(String url, Class<T> responseType, Object...
		 * uriVariables) throws RestClientException
		 * 
		 */
		DataDto dto = restTemplate.
				getForObject(getURL, DataDto.class,id);
		System.out.println(dto);
		return dto;
	}

}
