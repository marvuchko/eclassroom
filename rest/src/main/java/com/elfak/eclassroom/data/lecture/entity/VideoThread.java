package com.elfak.eclassroom.data.lecture.entity;

import com.elfak.eclassroom.data.base.entity.Base;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "video_thread")
public class VideoThread extends Base {

    @Column
    private String title;

    @ManyToOne
    @JoinColumn(name = "id_video")
    private Video video;

    @OneToMany(mappedBy = "videoThread", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private Set<VideoThreadMessage> messages;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
