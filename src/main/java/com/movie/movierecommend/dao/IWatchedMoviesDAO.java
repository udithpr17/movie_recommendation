package com.movie.movierecommend.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.movierecommend.model.UserData;
import com.movie.movierecommend.model.WatchedMovies;

@Repository
public interface IWatchedMoviesDAO extends JpaRepository<WatchedMovies, Integer> {

	List<WatchedMovies> findByUserAndWatchedDate(UserData user, LocalDate watchedDate);

}
