package com.example.demo.service;

import com.example.demo.module.Customer;

public interface CustomerService {
	Customer customerSignup(Customer c);

	Customer customerLogin(String data, String cpassword);

	Customer customervalidate(String data);

	Customer customerupdate(String data, String cpassword);
}
