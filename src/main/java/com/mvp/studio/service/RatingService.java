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

    /**
     * Updates the rating for the given movieTitle and then update video them into the DB.
     */
    public Video receiveRating(String movieTitle, int rating) {

        Map<String, Video> videos = videoService.getVideoMap();
        Video video = null;

        if (videos.containsKey(movieTitle)) {
            video = videos.get(movieTitle);
            saveRating(rating, video);
            video.setRating(calculateAverageRating(video.getId()));
            videoService.updateVideo(video);
        }
        return video;
    }

    private void saveRating(int rating, Video video) {
        Rating ratingToSave = new Rating();
        ratingToSave.setVideoRating(Long.valueOf(rating));
        ratingToSave.setVideoId(video.getId());
        ratingRepository.save(ratingToSave);
    }

    /**
     * This calculates the average rating. Fetches all the rating given to the video from the DB and returns the average rating.
     * @param videoID
     */
    private double calculateAverageRating(Long videoID) {

        List<Rating> ratings = ratingRepository.findAllByVideoId(videoID);

        int sum = 0;

        for(Rating ratingList : ratings){
            sum+=ratingList.getVideoRating();

        }
        return ratings.size() > 0 ?  sum/ratings.size() : 0;
    }

    public List<Rating> fetchAllRating() {
        return ratingRepository.findAll();
    }


    /**
     * As you can see by creating a Rating table and fetching ratings from the DB you have made
     * the code much more simple to implement less code less maintenance and easier to read.
     */
}
