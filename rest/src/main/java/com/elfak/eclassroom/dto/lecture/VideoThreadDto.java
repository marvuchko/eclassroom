package com.elfak.eclassroom.dto.lecture;

import com.elfak.eclassroom.dto.base.BaseDto;

import java.util.Set;

public class VideoThreadDto extends BaseDto {

    private long videoTimestamp;

    private String title;

    private Set<VideoThreadMessageDto> messages;

    public long getVideoTimestamp() {
        return videoTimestamp;
    }

    public void setVideoTimestamp(long videoTimestamp) {
        this.videoTimestamp = videoTimestamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<VideoThreadMessageDto> getMessages() {
        return messages;
    }

    public void setMessages(Set<VideoThreadMessageDto> messages) {
        this.messages = messages;
    }
}
