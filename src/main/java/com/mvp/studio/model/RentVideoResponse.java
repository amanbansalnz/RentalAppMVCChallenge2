package com.mvp.studio.model;


public class RentVideoResponse {

    private boolean videoRented;

    public boolean isVideoRented() {
        return videoRented;
    }

    public void setVideoRented(boolean videoRented) {
        this.videoRented = videoRented;
    }

    @Override
    public String toString() {
        return "RentVideoResponse{" +
                "videoRented=" + videoRented +
                '}';
    }
}
