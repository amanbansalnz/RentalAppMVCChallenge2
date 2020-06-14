package com.mvp.studio.service;

import com.mvp.studio.model.Video;
import com.mvp.studio.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


//@Service will be used by spring which tells spring to to inject
// dependency i.e. taking advantage of dependency injection
@Service
public class VideoService {

    private VideoRepository videoRepository;
    private Map<String, Video> videoMap;

    //default constructor where on creation of VideoService object
    //we want to initialise default behaviour
   public VideoService(VideoRepository videoRepository){
        this.videoRepository = videoRepository;
        this.videoMap = new HashMap<String, Video>();
        addInitialVideos();
    }

    //method to fetch all videos as a list.
    public List<Video> fetchAllVideos(){

       /* fetching from the database, also thanks to the JPA interface we do not have
         write an SQL select to find all videos as this is done for us by spring.
        */
        List<Video> videos = videoRepository.findAll();

        return videos;
    }


    //method to add video
    public Video addVideo(String videoName) {
        Video video = new Video(videoName);
        //saving into db
        videoRepository.save(video);
        videoMap.put(videoName, video);
        return video;
    }

    //new method that will save the new changes to the video object back into the DB
    public Video updateVideo(Video video) {
        videoRepository.save(video);
        return video;
    }


    //Note here we have copied this code from the previous video
    //rental project where we are adding predefined movies.
    private void addInitialVideos() {
        List<Video> videos = videoRepository.findAll();

        //adding the the list of videos to a map.
        videoMap = videos.stream()
                .collect(Collectors.toMap(Video::getMovieTitle, video -> video));

    }

    //getter and setter
    public Map<String, Video> getVideoMap() {
        return videoMap;
    }
}
