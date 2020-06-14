package com.mvp.studio.model;


public class HealthResponse {

    private boolean healthy;

    public HealthResponse(boolean healthy) {
        this.healthy = healthy;
    }

    public boolean isHealthy() {
        return healthy;
    }
}
