package com.mvp.studio.model;

public class RatingVideoResponse {

    private Video video;

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "RatingVideoResponse{" +
                "video=" + video +
                '}';
    }
}
