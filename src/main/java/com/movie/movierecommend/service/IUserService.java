package com.movie.movierecommend.service;

import java.util.Optional;


import com.movie.movierecommend.model.UserData;

public interface IUserService {

	UserData saveUser(UserData userData);

	static Optional<UserData> getUserById(Integer userId) {
		return null;
	}

}
