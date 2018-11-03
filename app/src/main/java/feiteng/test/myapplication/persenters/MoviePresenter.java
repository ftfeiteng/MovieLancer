package feiteng.test.myapplication.persenters;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import feiteng.test.myapplication.rest.data.Movie;
import feiteng.test.myapplication.rest.data.MovieResult;
import feiteng.test.myapplication.rest.service.MovieService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MoviePresenter {

    private final String API_KEY = "ac84c9dbd982a62aed1f0f5df62673d1";
    private final String POSTER_BASE_URL="http://image.tmdb.org/t/p/w185//";
    List<Movie> movieList = new ArrayList<>();

    @Inject
    MovieService service;
    MovieInterface.ViewInterface view;

    @Inject
    MoviePresenter(MovieInterface.ViewInterface viewInterface) {
        view = viewInterface;
    }

    //Request List of MovieResult
    public void sendRequest() {
        service.getPopularMovies(API_KEY).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<MovieResult>() {
                    @Override
                    public void onNext(MovieResult value) {
                        Log.d("TF_TEST", "Got Response");
                        movieList = value.getResults();
                        view.updateDataSet();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TF_TEST", "On Error:" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d("TF_TEST", "On Complete");

                    }
                });
    }

    // get item count in the list
    public int getItemCount(){
        return movieList.size();
    }

    //called when bindview
    public void onBindViewHolder(MovieInterface.ViewHolderInterface view, int position){
        if(position >= 0 && position < movieList.size()) {
            Movie movie = movieList.get(position);
            view.setTitle(movie.getTitle());
            double rating = movie.getVoteAverage();
            view.setStar((float) rating / 2f);
            view.setPostUrl(POSTER_BASE_URL + movie.getPosterPath());
        }
    }
}
