package com.mvp.studio.model;

import java.util.ArrayList;
import java.util.List;

public class VideoResponse {

    private List<Video> videos = new ArrayList<>();

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}
