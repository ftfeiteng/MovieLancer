package feiteng.test.myapplication.mvp.model;


import javax.inject.Inject;

import feiteng.test.myapplication.rest.data.MovieResponse;
import feiteng.test.myapplication.rest.service.MovieService;
import io.reactivex.Observable;

public class MovieModel {
    @Inject
    MovieService service;

    @Inject
    public MovieModel() {

    }
    // simple wrapper for service

    public Observable<MovieResponse> getPopularMovies(String apiKey) {
        return service.getPopularMovies(apiKey);
    }
}
