package com.elfak.eclassroom.data.lecture.entity;

import com.elfak.eclassroom.data.base.entity.Base;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "video")
public class Video extends Base {

    @Column
    private String title;

    @Column(length = 2048)
    private String videoUrl;

    @Column(length = 2048)
    private String thumbnailUrl;

    @Column
    private Long durationInSeconds;

    @ManyToOne
    @JoinColumn(name = "id_lecture")
    private Lecture lecture;

    @OneToMany(mappedBy = "video", fetch = FetchType.LAZY)
    private Set<VideoThread> videoThreads;

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

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public Set<VideoThread> getVideoThreads() {
        return videoThreads;
    }

    public void setVideoThreads(Set<VideoThread> videoThreads) {
        this.videoThreads = videoThreads;
    }
}
