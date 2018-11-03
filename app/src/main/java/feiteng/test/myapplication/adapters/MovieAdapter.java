package feiteng.test.myapplication.adapters;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.iarcuschin.simpleratingbar.SimpleRatingBar;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import javax.inject.Inject;

import feiteng.test.myapplication.R;
import feiteng.test.myapplication.persenters.MoviePresenter;
import feiteng.test.myapplication.persenters.MovieInterface;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    MoviePresenter presenter;
    ImageLoaderConfiguration conf;


    public MovieAdapter(Context context, MoviePresenter presenter) {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .resetViewBeforeLoading(true)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        ImageLoaderConfiguration conf = new ImageLoaderConfiguration.Builder(context)
                .defaultDisplayImageOptions(options)
                .threadPoolSize(5)
                .build();
        ImageLoader.getInstance().init(conf);
        this.presenter = presenter;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false));
    }

    @Override
    public int getItemCount() {
        return presenter.getItemCount();
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        presenter.onBindViewHolder(holder, position);
    }

    class MovieViewHolder extends RecyclerView.ViewHolder implements MovieInterface.ViewHolderInterface {
        private TextView titleTextView;
        private SimpleRatingBar ratingBar;
        private ImageView imageView;

        public MovieViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title_textview);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            imageView = itemView.findViewById(R.id.poster_imageview);
        }

        @Override
        public void setTitle(String title) {
            titleTextView.setText(title);
        }

        @Override
        public void setStar(float star) {
            ratingBar.setRating(star);
        }

        @Override
        public void setPostUrl(String url) {
            ImageLoader.getInstance().displayImage(url, imageView);
        }

    }
}
