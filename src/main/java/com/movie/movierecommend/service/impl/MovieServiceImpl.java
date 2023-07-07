package com.movie.movierecommend.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.movierecommend.dao.IMoviesDAO;
import com.movie.movierecommend.model.Movies;
import com.movie.movierecommend.service.IMoviesService;

@Service
public class MovieServiceImpl implements IMoviesService {
	
	@Autowired
	private IMoviesDAO dao;

	@Override
	public List<Movies> getAllMovies() {
		return dao.findAll();
	}

	@Override
	public List<Movies> getByMovie(String name) {
		return dao.findByNameIgnoreCase(name);
	}

	@Override
	public Optional<Movies> getByMovieId(Integer id) {
		return dao.findById(id);

	}

	@Transactional
	@Override
	public boolean deleteMovie(Integer id) {
		dao.delete(id);
		return true;
	}

	@Override
	public Movies updateMovie(Movies updateMovie) {
		Optional<Movies> movieId = dao.findById(updateMovie.getId());
		if (movieId.isPresent()) {
			Movies getMovie = movieId.get();
			BeanUtils.copyProperties(updateMovie, getMovie, "id");
			dao.save(getMovie);
		} else {
			return null;
		}
		return updateMovie;

	}

	@Override
	public Movies saveMovies(Movies saveMovie) {
		return dao.save(saveMovie);

	}

}
