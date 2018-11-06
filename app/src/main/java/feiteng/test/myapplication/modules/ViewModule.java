package feiteng.test.myapplication.modules;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import feiteng.test.myapplication.mvp.model.MovieModel;
import feiteng.test.myapplication.mvp.presenters.MovieInterface;
import feiteng.test.myapplication.rest.service.MovieService;

@Module
public class ViewModule {

    private MovieInterface.ViewInterface view;
    @Inject
    MovieService service;

    public ViewModule(MovieInterface.ViewInterface view) {
        this.view = view;
    }

    @Provides
    public MovieInterface.ViewInterface providerView() {
        return view;
    }
}
