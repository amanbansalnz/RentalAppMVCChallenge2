package com.mvp.studio.controller;

import com.mvp.studio.model.RatingVideoRequest;
import com.mvp.studio.model.RatingVideoResponse;
import com.mvp.studio.model.RentVideoRequest;
import com.mvp.studio.model.RentVideoResponse;
import com.mvp.studio.model.ReturnVideoRequest;
import com.mvp.studio.model.ReturnVideoResponse;
import com.mvp.studio.model.Video;
import com.mvp.studio.service.RatingService;
import com.mvp.studio.service.RentalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/*
  RentalController to create new functionality to all videos to be rented or rented.
 */
@RestController
@RequestMapping("/v1/video")
public class RatingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RatingController.class);

    //RatingService service injected so we can use the service to carry out certain functions
    @Autowired
    private RatingService ratingService;

    /*
     Implement the rate resource which takes a RatingVideoRequest that provides the movie title and a rating to rate and returns a
     RatingVideoResponse which returns the video that was rated otherwise null if video does not exist.
     */
    @PostMapping(value = "/rate", produces = MediaType.APPLICATION_JSON_VALUE, consumes =  MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus(HttpStatus.OK) // return response code 200
    public RatingVideoResponse checkOut(@RequestBody RatingVideoRequest ratingVideoRequest) {

        LOGGER.info("Rating video request >>> {}", ratingVideoRequest);

        Video ratedVideo = ratingService.receiveRating(ratingVideoRequest.getMovieTitle(), ratingVideoRequest.getRating());

        RatingVideoResponse ratingVideoResponse = new RatingVideoResponse();
        ratingVideoResponse.setVideo(ratedVideo);

        LOGGER.info("Rating video  response <<< {}", ratingVideoResponse);
        return ratingVideoResponse;
    }

}
