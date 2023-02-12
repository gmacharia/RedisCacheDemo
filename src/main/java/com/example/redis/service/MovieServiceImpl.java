/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.redis.service;

import com.example.redis.dto.Movies;
import com.example.redis.repository.RedisRepo;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author kobe
 */
@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    
    private final RedisRepo redisRepo;

    @Override
    public Movies saveMovies(Movies movie) {
        Movies response = redisRepo.saveMovies(movie);
        return response;
    }  
    
    @Override
    public List<Movies> fetchAllMovies() {
        return redisRepo.fetchAllMovies();
    }

    @Override
    public Movies fetchMovieById(Long id) {
        return redisRepo.fetchMovieById(id);
    }

    @Override
    public boolean deleteMovie(Long id) {
        return redisRepo.deleteMovie(id);
    }

    @Override
    public Movies updateMovie(Long id, Movies movie) {
        return redisRepo.updateMovie(id,movie);
    }
    
    
}
