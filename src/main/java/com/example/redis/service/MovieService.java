/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.redis.service;

import com.example.redis.dto.Movies;
import java.util.List;

/**
 *
 * @author kobe
 */
public interface MovieService {

    Movies saveMovies(Movies movie);

    List<Movies> fetchAllMovies();

    Movies fetchMovieById(Long id);

    boolean deleteMovie(Long id);

    boolean updateMovie(Long id, Movies movie);
}
