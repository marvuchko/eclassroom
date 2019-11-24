package com.elfak.eclassroom.dto.lecture;

import com.elfak.eclassroom.dto.base.BaseDto;

import java.util.Set;

public class VideoDto extends BaseDto {

    private String title;

    private String videoUrl;

    private String thumbnailUrl;

    private Long durationInSeconds;

    private Set<VideoThreadDto> threads;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public Long getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(Long durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public Set<VideoThreadDto> getThreads() {
        return threads;
    }

    public void setThreads(Set<VideoThreadDto> threads) {
        this.threads = threads;
    }
}
