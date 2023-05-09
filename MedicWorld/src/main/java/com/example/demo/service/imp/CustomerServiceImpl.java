package com.example.demo.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.exception.InvalidCredentials;
import com.example.demo.module.Customer;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepo repo;
	
	BCryptPasswordEncoder b1=new BCryptPasswordEncoder();

	@Override
	public Customer customerSignup(Customer c) {
		c.setCpassword(b1.encode(c.getCpassword()));
		// TODO Auto-generated method stub
		return repo.save(c);
	}

	@Override
	public Customer customerLogin(String data, String cpassword) {
		Customer c = repo.validate(data, data);
		if (c != null) {
			if (b1.matches(cpassword, c.getCpassword())) {
				return c;
			} else {
				throw new InvalidCredentials();
			}
		} else {
			throw new InvalidCredentials();
		}
	}

	@Override
	public Customer customervalidate(String data) {
		Customer c = repo.validate(data, data);
		if (c != null) {
			return c;
		} else {
			throw new InvalidCredentials();
		}
	}

	@Override
	public Customer customerupdate(String data, String cpassword) {
		Customer c = repo.validate(data, data);
		if (c != null) {
			c.setCpassword(cpassword);
			repo.save(c);
			return c;
		} else {
			throw new InvalidCredentials();
		}
	}

}
