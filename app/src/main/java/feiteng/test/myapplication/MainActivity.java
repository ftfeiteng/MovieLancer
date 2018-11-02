package feiteng.test.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import javax.inject.Inject;

import feiteng.test.myapplication.rest.data.MovieResult;
import feiteng.test.myapplication.rest.retrofit.MovieRetrofit;
import feiteng.test.myapplication.rest.service.MovieService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private String API_KEY = "ac84c9dbd982a62aed1f0f5df62673d1";
    @Inject
    MovieService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupComponent();

        service.getPopularMovies(API_KEY).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<MovieResult>() {
                    @Override
                    public void onNext(MovieResult value) {
                        Log.d("TF_TEST", "Got Response");
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

    private void setupComponent(){
        DaggerMainComponent.builder().build().inject(this);
    }
}
