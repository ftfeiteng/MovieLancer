package feiteng.test.myapplication.rest.retrofit;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *  Retrofit set up here
 */
public class MovieRetrofit {
    private String BASE_URL = "http://api.themoviedb.org/3/";
    private String API_KEY="ac84c9dbd982a62aed1f0f5df62673d1";

    private static Retrofit retrofit;

    public MovieRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }
}
