
package feiteng.test.myapplication.rest.data;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Generated Pojo class from json of the reponse
 * example Get:https://api.themoviedb.org/3/movie/popular?api_key=YOUR_API_KEY
 * The response should be MovieResponse (inculding Movie) in the JSON.
 */
@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class MovieResponse {
    @Expose
    private Long page;
    @SerializedName("total_pages")
    private Long totalPages;
    @SerializedName("total_results")
    private Long totalResults;
    @Expose
    private List<Movie> results;

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Long totalResults) {
        this.totalResults = totalResults;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> movie) {
        this.results = movie;
    }

}
