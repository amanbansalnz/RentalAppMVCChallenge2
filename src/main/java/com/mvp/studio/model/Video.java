package com.mvp.studio.model;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 * This sort of class is called a pojo where it only keeps state and attributes associated with this pojo
 */

@Entity
public class Video {

    public static final String SEQ_VIDEO_GEN = "SEQ_VIDEO_GEN";
    private static final String SEQ_NAME = "SEQ_VIDEO";
    @GenericGenerator(
            name = SEQ_VIDEO_GEN,
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = SEQ_NAME),
                    @Parameter(name = "allocation_size", value = "20")
            }
    )
    @Id
    @GeneratedValue(generator = SEQ_VIDEO_GEN, strategy = GenerationType.SEQUENCE)
    private Long id;
    private String movieTitle;
    private boolean isCheckedOut;
    private double rating;
    //private List<Double> ratingHistory = new ArrayList<Double>();


    public Video(){ //add a default construct for JPA needing to map object to DB table
    }

    public Video(String movieTitle){
        this.movieTitle = movieTitle;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {

        this.rating = rating;
//        ratingHistory.add(rating);
//
//        Double ratingSum = Double.valueOf(0);
//
//        for(Double d : ratingHistory){
//            ratingSum+=d; // same as averageRatingSum = averageRatingSum + integer;
//        }
//
//        this.rating = (ratingSum/ratingHistory.size());
    }

    @Override
    public String toString() {
        return  "|movieTitle: \"" + movieTitle + "\""+
                "|isCheckedOut:" + isCheckedOut +
                "|rating:" + getRating() + "|";
    }

}
