package com.movie.movierecommend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.movierecommend.model.UserData;

@Repository
public interface IUserDAO extends JpaRepository<UserData, Integer> {

}
