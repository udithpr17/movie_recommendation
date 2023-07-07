package com.movie.movierecommend.service;

import java.util.List;
import java.util.Optional;


import com.movie.movierecommend.model.Movies;

public interface IMoviesService {

	List<Movies> getAllMovies();
	
	List<Movies> getByMovie(String name);
	
	Optional<Movies> getByMovieId(Integer id);
	
	boolean deleteMovie(Integer id);
	
	Movies updateMovie(Movies updateMovie);

	Movies saveMovies(Movies saveMovie);
}
