package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {
@RequestMapping("/welcomeApi")
String dummyController() {
	return "Hello Doctor";
}
}
