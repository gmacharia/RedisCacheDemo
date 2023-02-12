package com.example.redis;

import com.example.redis.dto.Movies;
import com.example.redis.repository.RedisRepo;
import com.example.redis.service.MovieService;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDemoApplicationTests {

    @Autowired
    private MovieService movieService;

    public RedisDemoApplicationTests() {
    }

    @MockBean
    private RedisRepo repository;

    @Test
    public void getMovieTest() {
        when(repository.fetchAllMovies()).thenReturn(Stream
                .of(new Movies(1, "Who Killed My Family", "A mans family is killed and he goes back to revenge", "Action"),
                        new Movies(2, "Mobius", "A scientist who focus in treating his sickness ends up been something else", "Action")).collect(Collectors.toList()));
        assertEquals(2, movieService.fetchAllMovies().size());
    }

    @Test
    public void getMovieByIdTest() {
        long id = 1;
        Movies movie = new Movies(1, "Who Killed My Family", "A mans family is killed and he goes back to revenge", "Action");
        when(repository.fetchMovieById(id))
                .thenReturn(movie);
        assertEquals(movie, movieService.fetchMovieById(id));

    }

    @Test
    public void saveMovieTest() {
        Movies movie = new Movies(1, "Who Killed My Family", "A mans family is killed and he goes back to revenge", "Action");
        assertEquals(repository.saveMovies(movie), movieService.saveMovies(movie));
    }

    @Test
    public void deleteMovieTest() {
        long id = 1;

        Movies movie = new Movies(1, "Who Killed My Family", "A mans family is killed and he goes back to revenge", "Action");
        repository.deleteMovie(id);
        verify(repository, times(1)).deleteMovie(id);
    }

    @Test
    public void updateMovieTest() {
        long id = 1;

        Movies currentMovie = new Movies(1, "Who Killed My Family", "Amans faily is killed and he goes back to revenge", "Action");
        Movies edittedMovies = new Movies(); //holder
        
        edittedMovies.setDescription("A mans family is killed and he goes back for revenge");

        //lets create another for the updated change we want
        Movies newMovie = Movies.builder()
                .id(id)
                .title(currentMovie.getTitle())
                .description(edittedMovies.getDescription())
                .genre(currentMovie.getGenre())
                .build();
       
        assertEquals(repository.updateMovie(id, newMovie), movieService.fetchMovieById(id));

    }
}
