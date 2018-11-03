package feiteng.test.myapplication;

import android.view.View;

import javax.inject.Singleton;

import dagger.Component;
import feiteng.test.myapplication.modules.MovieModule;
import feiteng.test.myapplication.modules.ViewModule;

@Singleton
@Component(modules = {ViewModule.class,
        MovieModule.class})
public interface MainComponent {
    void inject(MainActivity activity);

}
