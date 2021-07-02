package com.paripassu.bankpass.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paripassu.bankpass.helpers.GenerateRandoPass;

@RestController
@RequestMapping("/users")
public class UserController {

	@GetMapping("/{type}")
	public String generateTicket(@PathVariable("type") String type) {
		GenerateRandoPass pass = new GenerateRandoPass();
		String ticket = pass.tickets(type);
		return ticket;
	}
}
