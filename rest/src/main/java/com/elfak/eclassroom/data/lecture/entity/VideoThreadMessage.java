package com.elfak.eclassroom.data.lecture.entity;

import com.elfak.eclassroom.data.base.entity.Base;
import com.elfak.eclassroom.data.user.entity.User;

import javax.persistence.*;

@Entity
@Table(name = "video_thread_message")
public class VideoThreadMessage extends Base {

    @Column
    private long videoTimestamp;

    @Column
    @Lob
    private String content;

    @ManyToOne
    @JoinColumn(name = "id_thread")
    private VideoThread videoThread;

    @Column
    private String authorFullName;

    @Column
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

    public VideoThread getVideoThread() {
        return videoThread;
    }

    public void setVideoThread(VideoThread videoThread) {
        this.videoThread = videoThread;
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
