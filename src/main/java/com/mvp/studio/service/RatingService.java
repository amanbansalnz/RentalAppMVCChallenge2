package com.mvp.studio.service;


import com.mvp.studio.model.Rating;
import com.mvp.studio.model.Video;
import com.mvp.studio.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is the service class which carries out the core functionality around rating a video.
 */
@Service
public class RatingService {

    private VideoService videoService;
    private RatingRepository ratingRepository;

    public RatingService(VideoService videoService, RatingRepository ratingRepository){
        this.videoService = videoService;
        this.ratingRepository = ratingRepository;
    }

//    private Map<Long, List<Integer>> ratings = new HashMap<>();

    /**
     * Updates the rating for the given movieTitle and then update them into the DB.
     */
    public Video receiveRating(String movieTitle, int rating) {

        Map<String, Video> videos = videoService.getVideoMap();
        Video video = null;

        if (videos.containsKey(movieTitle)) {
            video = videos.get(movieTitle);

            Rating ratingToSave = new Rating();
            ratingToSave.setVideoRating(Long.valueOf(rating));
            ratingToSave.setVideoId(video.getId());

            ratingRepository.save(ratingToSave);

//            List<Rating> ratings = ratingRepository.findAllByVideoId(video.getId());
            List<Rating> ratings = new ArrayList<>();
            double averageRating = calculateAverageRating(ratings);
            video.setRating(averageRating);
            videoService.updateVideo(video);
        }
        return video;
    }

    private double calculateAverageRating(List<Rating> ratings) {
        int sum = 0;
        for(Rating ratingList : ratings){
            sum+=ratingList.getVideoRating();

        }
        return ratings.size() > 0 ?  sum/ratings.size() : 0;
    }


    /**
     * This calculates the average rating. The map is used to store the ratings in a list and the key being the video ID which is unique.
     * If the rating map does not contain the rating it adds a new entry into the map, if it does contain it then it appends it to the existing list.
     */
//    private double calculateAverageRating(Long movieId, int rating) {
//
//        double averageRating = rating;
//
//        if(ratings.containsKey(movieId)){
//            List<Integer> ratingList = ratings.get(movieId);
//            ratingList.add(rating);
//
//            int sum = 0;
//            for(Integer integer : ratingList){
//                sum+=integer;
//            }
//
//            ratings.put(movieId, ratingList);
//            averageRating = sum/ratingList.size();
//
//        }else{
//            List<Integer> ratingList = new ArrayList<>();
//            ratingList.add(rating);
//            ratings.put(movieId, ratingList);
//        }
//
//        return averageRating;
//    }

}
