package za.ac.cput.novacinemaapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.novacinemaapp.domain.Movie;
import za.ac.cput.novacinemaapp.repository.MovieRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService {
    private final MovieRepository repository;

    @Autowired
    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public Movie create(Movie movie) {
        return repository.save(movie);
    }
    @Override
    public Movie update(Movie movie) {
        return repository.save(movie);
    }
    @Override
    public Movie read(String s) {
        return repository.findById(s).orElse(null);
    }



    @Override
    public Set<Movie> getall() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }
}
