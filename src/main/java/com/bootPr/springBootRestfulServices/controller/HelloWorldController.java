package com.bootPr.springBootRestfulServices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootPr.springBootRestfulServices.beans.HelloWorldBean;

@RestController
public class HelloWorldController {

	@GetMapping(path="/hello-world")
	public String hello() {
		return "Hello World !!";
	}
	
	
	@GetMapping(path="/helloBean")
	public HelloWorldBean getBeanMessage() {
		HelloWorldBean bean = new HelloWorldBean();
		bean.setMessage("Hello Howdy  !!!");
		return bean;
	}
}
