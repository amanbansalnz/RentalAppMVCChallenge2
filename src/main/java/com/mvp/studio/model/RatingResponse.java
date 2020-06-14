package com.mvp.studio.model;

import java.util.List;

public class RatingResponse {

    private List<Rating> ratings;

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "RatingResponse{" +
                "ratings=" + ratings +
                '}';
    }
}
