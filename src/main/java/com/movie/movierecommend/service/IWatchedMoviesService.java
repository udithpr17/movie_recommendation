package com.movie.movierecommend.service;


import com.movie.movierecommend.response.ResponseDTO;

public interface IWatchedMoviesService {

	ResponseDTO recommendMovie(Integer userId);

}
