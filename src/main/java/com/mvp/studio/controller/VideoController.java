package com.mvp.studio.controller;

import com.mvp.studio.model.AddVideoRequest;
import com.mvp.studio.model.AddVideoResponse;
import com.mvp.studio.model.Video;
import com.mvp.studio.model.VideoResponse;
import com.mvp.studio.service.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/video")
public class VideoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VideoController.class);

    @Autowired
    private VideoService videoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public VideoResponse fetchVideos() {
        VideoResponse videoResponse = new VideoResponse();
        videoResponse.setVideos(videoService.fetchAllVideos());
        return videoResponse;
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes =  MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus(HttpStatus.CREATED) // return response code 201
    public AddVideoResponse addVideo(@RequestBody AddVideoRequest addVideoRequest) {

        Video video = videoService.addVideo(addVideoRequest.getMovieTitle());

        LOGGER.info("Adding video request >>> {}", addVideoRequest);
        AddVideoResponse addVideoResponse = new AddVideoResponse();
        addVideoResponse.setVideo(video);
        LOGGER.info("Added video  response <<< {}", addVideoResponse);
        return addVideoResponse;
    }
}
