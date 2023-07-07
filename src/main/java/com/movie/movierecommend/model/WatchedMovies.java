package com.movie.movierecommend.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="watched_movies")
public class WatchedMovies {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private UserData user;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserData getUser() {
		return user;
	}

	public void setUser(UserData user) {
		this.user = user;
	}

	public Movies getMovie() {
		return movies;
	}

	public void setMovie(Movies movie) {
		this.movies = movie;
	}

	public LocalDate getWatchedDate() {
		return watchedDate;
	}

	public void setWatchedDate(LocalDate watchedDate) {
		this.watchedDate = watchedDate;
	}

	@ManyToOne
    @JoinColumn(name = "movie_id")
    private Movies movies;

    @Column(name = "watched_date")
    private LocalDate watchedDate;

}
