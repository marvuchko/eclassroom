package com.elfak.eclassroom.dto.lecture;

import com.elfak.eclassroom.dto.base.BaseDto;

public class VideoThreadMessageDto extends BaseDto {

    private long videoTimestamp;

    private String content;

    private String authorFullName;

    private String authorEmail;

    public long getVideoTimestamp() {
        return videoTimestamp;
    }

    public void setVideoTimestamp(long videoTimestamp) {
        this.videoTimestamp = videoTimestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }
}
