package com.elfak.eclassroom.dto.lecture;

import com.elfak.eclassroom.dto.base.BaseDto;
import com.elfak.eclassroom.dto.user.UserDto;

import java.util.Set;
import java.util.UUID;

public class LectureDto extends BaseDto {

    private String title;

    private String description;

    private Set<VideoDto> videos;

    private UserDto tutor;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<VideoDto> getVideos() {
        return videos;
    }

    public void setVideos(Set<VideoDto> videos) {
        this.videos = videos;
    }

    public UserDto getTutor() {
        return tutor;
    }

    public void setTutor(UserDto tutor) {
        this.tutor = tutor;
    }
}
