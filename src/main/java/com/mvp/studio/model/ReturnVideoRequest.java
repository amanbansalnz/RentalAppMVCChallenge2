package com.mvp.studio.model;

public class ReturnVideoRequest {

    private String movieTitle;

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    @Override
    public String toString() {
        return "AddVideoRequest{" +
                "movieTitle='" + movieTitle + '\'' +
                '}';
    }
}
