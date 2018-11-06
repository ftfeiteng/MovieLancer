package feiteng.test.myapplication;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import feiteng.test.myapplication.mvp.model.MovieModel;
import feiteng.test.myapplication.mvp.presenters.MovieInterface;
import feiteng.test.myapplication.mvp.presenters.MoviePresenter;
import feiteng.test.myapplication.rest.data.Movie;
import feiteng.test.myapplication.rest.data.MovieResponse;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MoviePresenterTest {

    @Mock
    private MovieModel model;

    @Mock
    private MovieInterface.ViewInterface viewInterface;

    private MoviePresenter presenter;

    @BeforeClass
    public static void setupClass() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(
                new Function<Callable<Scheduler>, Scheduler>() {
                    @Override
                    public Scheduler apply(Callable<Scheduler> a) throws Exception {
                        return Schedulers.trampoline();
                    }
                });
    }

    @Before
    public void setup() {
        presenter = new MoviePresenter(viewInterface, model);
    }

    @Test
    public void testResponseSomething() {
        //given
        MovieResponse response = mock(MovieResponse.class);
        Movie movie = mock(Movie.class);
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(movie);

        //when
        when(response.getTotalResults()).thenReturn((long) 1);
        when(response.getResults()).thenReturn(new ArrayList<Movie>(movies));
        when(model.getPopularMovies(MoviePresenter.API_KEY)).thenReturn(Observable.just(response));
        presenter.sendRequest();

        //then
        verify(response).getResults();
        verify(viewInterface).updateDataSet();
        assertEquals(1, presenter.getItemCount());
    }
}
