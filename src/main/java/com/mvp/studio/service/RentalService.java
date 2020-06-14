package com.mvp.studio.service;


import com.mvp.studio.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * This is the service class which carries out the core functionality around video renting
 */
@Service
public class RentalService {
    /**
      Spring will inject the VideoService object, it is the same as creating
      VideoService videoService = new VideoService()
      in the real we let spring handle all the dependency injection which is like saying
      RentalService has a dependency VideoService. This is the magic of spring.
     */
    @Autowired
    private VideoService videoService;


    /**
      We will now comment the following code below as this does not make sense to be here
      as this is not part of the rental service but the video service. It makes more sense
      if the video service returns information about the videos in the inventory its service says such.
      Where as the Rental Service should be worried about the renting functionality.
      Think in terms of services being focused on a single responsibility.
     */

    public boolean checkOut(String videoName) {
        //retrieve the video map from the Video service now
        Map<String, Video> videos = videoService.getVideoMap();
        boolean isCheckedOut = false;

        if (videos.containsKey(videoName)) {
            Video video = videos.get(videoName);
            if (!video.isCheckedOut()) {
                video.setCheckedOut(true);
                //we want to save the new video state to save into the DB
                videoService.updateVideo(video);
                isCheckedOut = true;
            }
        }
        return isCheckedOut;
    }

    public boolean returnVideo(String videoName) {
        Map<String, Video> videos = videoService.getVideoMap();
        boolean isReturned = false;

        if (videos.containsKey(videoName)) {
            Video video = videos.get(videoName);
            if (video.isCheckedOut()) {
                video.setCheckedOut(false);

                //we want to save the new video state to save into the DB
                videoService.updateVideo(video);
                isReturned = true;
            }
        }
        return isReturned;
    }

    public void receiveRating(String videoName, int rating) {
        Map<String, Video> videos = videoService.getVideoMap();
        if (videos.containsKey(videoName)) {
            Video video = videos.get(videoName);
            video.setRating(rating);
        }
    }

    /**
     * We do not need this now as the GET video resource fetches all the videos which shows you what video's are available to return or return
     */
//    public String listInventory() {
//        Map<String, Video> videos = videoService.getVideoMap();
//        //Important to know the difference between String StringBuilder and StringBuffer
//        StringBuilder builder = new StringBuilder("\n-------------------------------------- List Of Videos To Checkout ------------------------------------- \n");
//
//        for (Map.Entry<String, Video> entry : videos.entrySet()) {
//            Video video = entry.getValue();
//            builder.append(video.toString());
//        }
//        return builder.toString();
//    }

}
