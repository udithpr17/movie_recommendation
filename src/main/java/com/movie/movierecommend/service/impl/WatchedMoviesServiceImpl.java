package com.movie.movierecommend.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.movierecommend.dao.IMoviesDAO;
import com.movie.movierecommend.dao.IUserDAO;
import com.movie.movierecommend.dao.IWatchedMoviesDAO;
import com.movie.movierecommend.model.Movies;
import com.movie.movierecommend.model.UserData;
import com.movie.movierecommend.model.WatchedMovies;
import com.movie.movierecommend.response.ResponseDTO;
import com.movie.movierecommend.service.IWatchedMoviesService;

@Service
public class WatchedMoviesServiceImpl implements IWatchedMoviesService {
	
	

	@Autowired
	private IMoviesDAO movieDao;

	@Autowired
	private IUserDAO userDao;
	
	@Autowired
	private IWatchedMoviesDAO dao;


	@Override
	public ResponseDTO recommendMovie(Integer userId) {
	 try {
			
		UserData user = userDao.findById(userId).orElseThrow();

		LocalDate today = LocalDate.now();
		List<WatchedMovies> watchedMovie = dao.findByUserAndWatchedDate(user, today);
		if (!watchedMovie.isEmpty()) {
			return new ResponseDTO(208, true, "Today's recommendation", watchedMovie);
		}

		List<Movies> unWatchedMovie = movieDao.findUnwatchedMovies(userId);
		if (unWatchedMovie.isEmpty()) {
			return new ResponseDTO(400, false, "No movies available for recommendation", null);
		}

		int randomIndex = new Random().nextInt(unWatchedMovie.size());
		Movies recommendedMovie = unWatchedMovie.get(randomIndex);
		WatchedMovies newMovie = new WatchedMovies();
		newMovie.setUser(user);
		newMovie.setMovie(recommendedMovie);
		newMovie.setWatchedDate(today);
		dao.save(newMovie);

		return new ResponseDTO(200, true, "Today's recommendation", newMovie);
	 
	}
	
	catch(Exception ex)
	{
		return new ResponseDTO(400,false,"Bad Request",null);
	}


	}	

}
