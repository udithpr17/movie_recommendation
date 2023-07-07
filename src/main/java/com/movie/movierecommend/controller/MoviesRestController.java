package com.movie.movierecommend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.movierecommend.model.Movies;
import com.movie.movierecommend.service.IMoviesService;

@RestController
public class MoviesRestController {

	@Autowired
	private IMoviesService service;

	@PostMapping("save-movie")
	public Movies saveUser(@RequestBody Movies movie) {
		return service.saveMovies(movie);
	}

	@GetMapping("get-all-movies")
	public List<Movies> getAll() {
		return service.getAllMovies();
	}

	@GetMapping("get-movie-by-id/{id}")
	public Optional<Movies> getById(@PathVariable Integer id) {
		return service.getByMovieId(id);
	}

	@GetMapping("get-movie-by-name/{name}")
	public List<Movies> getByName(@PathVariable String name) {
		return service.getByMovie(name);
	}

	@PutMapping("update-movie")
	public Movies update(@RequestBody Movies movie) {
		return service.updateMovie(movie);
	}

	@DeleteMapping("delete-movie/{id}")
	public boolean deleteBook(@PathVariable Integer id) {
		return service.deleteMovie(id);
	}

}
