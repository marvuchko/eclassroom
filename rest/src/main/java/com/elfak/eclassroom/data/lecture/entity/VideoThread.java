package com.elfak.eclassroom.data.lecture.entity;

import com.elfak.eclassroom.data.base.entity.Base;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "video_thread")
public class VideoThread extends Base {

    @Column
    private long videoTimestamp;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String authorName;

    @Column
    private String authorEmail;

    @ManyToOne
    @JoinColumn(name = "id_video")
    private Video video;

    @OneToMany(mappedBy = "videoThread")
    @Cascade(value = {org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    private Set<VideoThreadMessage> messages;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Set<VideoThreadMessage> getMessages() {
        return messages;
    }

    public void setMessages(Set<VideoThreadMessage> messages) {
        this.messages = messages;
    }
}
