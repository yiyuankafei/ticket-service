package com.ticket.application.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hello.application.service.HelloService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Reference(group = "hello-service", version = "1.0.0")
	HelloService helloService;
	
	
	@RequestMapping("/test")
	public String test() {
		return "here is ticket-service";
	}
	
	@RequestMapping("/hello")
	public String hello(String name) {
		return helloService.sayHello(name);
	}

}
