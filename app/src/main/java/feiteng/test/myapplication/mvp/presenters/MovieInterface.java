package feiteng.test.myapplication.mvp.presenters;

public interface MovieInterface {
    public interface ViewInterface {
        void updateDataSet();
    }

    public interface ViewHolderInterface {
        // set title of a movie to a view holder
        void setTitle(String title);

        //set rating star for a movie
        void setStar(float star);

        //set Url of Image
        void setPostUrl(String url);
    }

}
