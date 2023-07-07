package com.movie.movierecommend.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.movierecommend.dao.IUserDAO;
import com.movie.movierecommend.model.UserData;
import com.movie.movierecommend.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDAO dao;

	@Override
	public UserData saveUser(UserData userData) {
		dao.save(userData);
		return userData;
	}

	
}
