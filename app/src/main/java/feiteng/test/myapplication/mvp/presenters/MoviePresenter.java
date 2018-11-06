package feiteng.test.myapplication.mvp.presenters;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import feiteng.test.myapplication.mvp.model.MovieModel;
import feiteng.test.myapplication.rest.data.Movie;
import feiteng.test.myapplication.rest.data.MovieResponse;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MoviePresenter {

    public static final String API_KEY = "ac84c9dbd982a62aed1f0f5df62673d1";
    private static final String POSTER_BASE_URL="http://image.tmdb.org/t/p/w185//";
    List<Movie> movieList = new ArrayList<>();

    MovieModel model;
    MovieInterface.ViewInterface view;

    @Inject
    public MoviePresenter(MovieInterface.ViewInterface viewInterface, MovieModel model) {
        view = viewInterface;
        this.model = model;
    }

    //Request List of MovieResponse
    public void sendRequest() {
        model.getPopularMovies(API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<MovieResponse>() {
                    @Override
                    public void onNext(MovieResponse value) {
                        movieList = value.getResults();
                        view.updateDataSet();
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
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
