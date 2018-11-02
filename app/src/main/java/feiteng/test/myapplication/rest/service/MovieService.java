package feiteng.test.myapplication.rest.service;

import feiteng.test.myapplication.rest.data.MovieResult;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {

    @GET("movie/popular")
    Observable<MovieResult> getPopularMovies(@Query("api_key") String apiKey);
}
