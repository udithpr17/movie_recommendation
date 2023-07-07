package com.movie.movierecommend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.movie.movierecommend.model.Movies;

@Repository
public interface IMoviesDAO extends JpaRepository<Movies, Integer> {

	@Query("SELECT m FROM Movies m WHERE m NOT IN (SELECT w.movies FROM WatchedMovies w WHERE w.user.id = :userId) AND m.deleted != true")
	List<Movies> findUnwatchedMovies(@Param("userId") Integer userId);

	List<Movies> findByNameIgnoreCase(String name);
	
	@Modifying
	@Query(value = "Update Movies e set e.deleted=true where e.id=:id")
	void delete(Integer id);

}
