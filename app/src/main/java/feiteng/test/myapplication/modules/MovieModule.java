package feiteng.test.myapplication.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import feiteng.test.myapplication.rest.retrofit.MovieRetrofit;
import feiteng.test.myapplication.rest.service.MovieService;

@Module
public class MovieModule {

    @Singleton
    @Provides
    // for RxJava
    public MovieRetrofit provideMovieRetrofit(){
        return new MovieRetrofit();
    }

    @Singleton
    @Provides
    // for RxJava
    public MovieService provideMovieService(MovieRetrofit movieRetrofit){
        return movieRetrofit.getRetrofit().create(MovieService.class);
    }
}
