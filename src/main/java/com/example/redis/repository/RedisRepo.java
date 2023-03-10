/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.redis.repository;

import com.example.redis.dto.Movies;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kobe
 */
@Repository
@RequiredArgsConstructor
public class RedisRepo {

    private final RedisTemplate redisTemplate;

    private static final String KEY = "MOVIE";

    public Movies saveMovies(Movies movie) {
        redisTemplate.opsForHash().put(KEY, movie.getId(), movie);
        return movie;
    }

    public List<Movies> fetchAllMovies() {
        List<Movies> users;
        users = redisTemplate.opsForHash().values(KEY);
        return users;
    }

    public Movies fetchMovieById(Long id) {
        Movies movie;
        movie = (Movies) redisTemplate.opsForHash().get(KEY, id.toString());
        return movie;
    }

    public boolean deleteMovie(Long id) {
        try {
            redisTemplate.opsForHash().delete(KEY, id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Movies updateMovie(Long id, Movies movie) {
        redisTemplate.opsForHash().put(KEY, id, movie);
        return movie;
    }
}
