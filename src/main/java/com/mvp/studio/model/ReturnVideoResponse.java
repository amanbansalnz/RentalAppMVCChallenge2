package com.mvp.studio.model;


public class ReturnVideoResponse {

    private boolean videoReturn;

    public boolean isVideoReturn() {
        return videoReturn;
    }

    public void setVideoReturn(boolean videoReturn) {
        this.videoReturn = videoReturn;
    }

    @Override
    public String toString() {
        return "RentVideoResponse{" +
                "videoRented=" + videoReturn +
                '}';
    }
}
