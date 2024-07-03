package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.service.RestClientService;

@RestController
@RequestMapping("/rest_clnt")
public class RestClientController {
	@Autowired
	private RestClientService restClientService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getData(@PathVariable int id) 
	{
		System.out.println("in get data");
		return ResponseEntity.ok(restClientService.getData(id));
	}
	
}
