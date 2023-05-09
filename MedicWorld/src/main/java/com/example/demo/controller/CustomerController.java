package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.module.Customer;
import com.example.demo.service.imp.CustomerServiceImpl;

@RestController
public class CustomerController {
	@Autowired
	CustomerServiceImpl impl;

	@PostMapping("/CustomerSignup")
	ResponseEntity<Customer> customerSignup(@RequestBody Customer c) {
		return new ResponseEntity<Customer>(impl.customerSignup(c), HttpStatus.CREATED);
	}

	@GetMapping("/CustomerLogin")
	ResponseEntity<Customer> customerLogin(@RequestHeader String data, @RequestHeader String cpassword) {
		return new ResponseEntity<Customer>(impl.customerLogin(data, cpassword), HttpStatus.FOUND);
	}

	@GetMapping("/CustomerValidate")
	ResponseEntity<Customer> customervalidate(@RequestHeader String data) {
		return new ResponseEntity<Customer>(impl.customervalidate(data), HttpStatus.FOUND);
	}

	@PutMapping("/CustomerUpdatepass")
	ResponseEntity<Customer> customerupdate(@RequestHeader String data, @RequestHeader String cpassword) {
		return new ResponseEntity<Customer>(impl.customerupdate(data, cpassword), HttpStatus.FOUND);
	}
}
