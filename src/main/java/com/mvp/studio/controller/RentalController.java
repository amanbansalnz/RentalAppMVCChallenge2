package com.mvp.studio.controller;

import com.mvp.studio.model.RentVideoRequest;
import com.mvp.studio.model.RentVideoResponse;
import com.mvp.studio.model.ReturnVideoRequest;
import com.mvp.studio.model.ReturnVideoResponse;
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
public class RentalController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RentalController.class);

    //Rental service injected so we can use the service to carry out certain functions
    @Autowired
    private RentalService rentalService;

    /*
     Implement the rent resource which takes a RentVideoRequest that provides the movie title to rent and returns a RentVideoResponse which return true
     if movie is checkout otherwise false.
     */
    @PostMapping(value = "/rent", produces = MediaType.APPLICATION_JSON_VALUE, consumes =  MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus(HttpStatus.OK) // return response code 200
    public RentVideoResponse checkOut(@RequestBody RentVideoRequest rentVideoRequest) {

        //basic logging to give us some insight whats happening.
        LOGGER.info("Renting video request >>> {}", rentVideoRequest);

        boolean videoRented = rentalService.checkOut(rentVideoRequest.getMovieTitle());


        RentVideoResponse rentVideoResponse = new RentVideoResponse();
        rentVideoResponse.setVideoRented(videoRented);

        LOGGER.info("Renting video  response <<< {}", rentVideoResponse);
        return rentVideoResponse;
    }


    /*
     Implement the return resource which takes a ReturnVideoRequest that provides the movie title to rent and returns a ReturnVideoResponse which return true
     if movie is returned otherwise false.
     */
    @PostMapping(value = "/return", produces = MediaType.APPLICATION_JSON_VALUE, consumes =  MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus(HttpStatus.OK) // return response code 200
    public ReturnVideoResponse returnVideo(@RequestBody ReturnVideoRequest returnVideoRequest) {

        LOGGER.info("Returning video request >>> {}", returnVideoRequest);

        boolean videoReturned = rentalService.returnVideo(returnVideoRequest.getMovieTitle());

        ReturnVideoResponse returnVideoResponse = new ReturnVideoResponse();
        returnVideoResponse.setVideoReturn(videoReturned);
        LOGGER.info("Returning video response <<< {}", returnVideoResponse);
        return returnVideoResponse;
    }
}
