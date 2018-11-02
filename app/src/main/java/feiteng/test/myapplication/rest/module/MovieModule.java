package feiteng.test.myapplication.rest.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import feiteng.test.myapplication.rest.retrofit.MovieRetrofit;
import feiteng.test.myapplication.rest.service.MovieService;

@Module
public class MovieModule {

    @Singleton
    @Provides
    public MovieRetrofit providerLocalRetrofit(){
        return new MovieRetrofit();
    }

    @Singleton
    @Provides
    public MovieService provideMovieRetrofit(MovieRetrofit movieRetrofit){
        return movieRetrofit.getRetrofit().create(MovieService.class);
    }
}
