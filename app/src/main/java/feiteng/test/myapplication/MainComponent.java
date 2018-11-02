package feiteng.test.myapplication;

import javax.inject.Singleton;

import dagger.Component;
import feiteng.test.myapplication.rest.module.MovieModule;

@Singleton
@Component(modules = MovieModule.class)
public interface MainComponent {
    void inject(MainActivity activity);
}
