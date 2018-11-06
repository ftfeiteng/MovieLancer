package feiteng.test.myapplication;

import javax.inject.Singleton;

import dagger.Component;
import feiteng.test.myapplication.modules.MovieModule;
import feiteng.test.myapplication.modules.ViewModule;
import feiteng.test.myapplication.mvp.views.MainActivity;

@Singleton
@Component(modules = {ViewModule.class,
        MovieModule.class})
public interface MainComponent {
    void inject(MainActivity activity);

}
