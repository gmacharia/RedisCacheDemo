/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.redis.controller;

import com.example.redis.dto.Movies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.redis.service.MovieService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author kobe
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/redis/v1")
public class RedisController {

    private final MovieService movieService;

    @PostMapping("/movie")
    public ResponseEntity<Movies> saveMovie(@RequestBody Movies movies) {
        return new ResponseEntity<>(movieService.saveMovies(movies), HttpStatus.OK);
    }

    @GetMapping("/movie")
    public ResponseEntity<List<Movies>> fetchAllUser() {
        List<Movies> users;
        users = movieService.fetchAllMovies();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<Movies> fetchUserById(@PathVariable("id") Long id) {
        Movies movies;
        movies = movieService.fetchMovieById(id);
        return ResponseEntity.ok(movies);
    }

    @DeleteMapping("/movie/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        boolean result = movieService.deleteMovie(id);
        if (result) {
            return ResponseEntity.ok("Movie deleted Successfully!!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/movie/{id}")
    public ResponseEntity<Movies> updateUser(@PathVariable("id") Long id, @RequestBody Movies movie) {
        return new ResponseEntity<>(movieService.updateMovie(id, movie), HttpStatus.OK);
      
    }

}
