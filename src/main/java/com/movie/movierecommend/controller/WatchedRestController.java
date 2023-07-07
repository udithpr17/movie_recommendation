package com.movie.movierecommend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.movie.movierecommend.response.ResponseDTO;
import com.movie.movierecommend.service.IWatchedMoviesService;

@RestController
public class WatchedRestController {

	@Autowired
	private IWatchedMoviesService service;
	
	@GetMapping("recommend-movie/{userId}")
	public ResponseDTO recommendMovie(@PathVariable Integer userId){
		return service.recommendMovie(userId);
	}

}
