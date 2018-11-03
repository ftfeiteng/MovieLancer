package feiteng.test.myapplication.modules;

import dagger.Module;
import dagger.Provides;
import feiteng.test.myapplication.persenters.MovieInterface;

@Module
public class ViewModule {

    private MovieInterface.ViewInterface view;

    public ViewModule( MovieInterface.ViewInterface view){
        this.view = view;
    }

    @Provides
    public  MovieInterface.ViewInterface providerView(){
        return view;
    }
}
