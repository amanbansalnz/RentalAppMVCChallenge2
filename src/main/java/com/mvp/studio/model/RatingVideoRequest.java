package com.mvp.studio.model;

public class RatingVideoRequest {

    private Integer rating;
    private String movieTitle;

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    @Override
    public String toString() {
        return "RatingVideoRequest{" +
                "rating=" + rating +
                ", movieTitle='" + movieTitle + '\'' +
                '}';
    }
}
