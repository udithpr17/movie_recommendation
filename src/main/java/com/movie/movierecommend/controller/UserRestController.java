package com.movie.movierecommend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.movierecommend.model.UserData;
import com.movie.movierecommend.service.IUserService;

@RestController
public class UserRestController {

	@Autowired
	private IUserService service;
	
	
	@PostMapping("save-user")
	public UserData saveUser(@RequestBody UserData userData) {
		return service.saveUser(userData);
	}

}
