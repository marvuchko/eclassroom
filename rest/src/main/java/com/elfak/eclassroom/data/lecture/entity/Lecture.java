package com.elfak.eclassroom.data.lecture.entity;

import com.elfak.eclassroom.data.base.entity.Base;
import com.elfak.eclassroom.data.user.entity.User;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "lecture")
public class Lecture extends Base {

    @Column
    private String title;

    @Column
    private String description;

    @OneToMany(mappedBy = "lecture")
    @Cascade(value = {org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    private Set<Video> videos;

    @ManyToOne
    @JoinColumn(name = "id_tutor")
    private User tutor;

    public User getTutor() {
        return tutor;
    }

    public void setTutor(User tutor) {
        this.tutor = tutor;
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

    public Set<Video> getVideos() {
        return videos;
    }

    public void setVideos(Set<Video> videos) {
        this.videos = videos;
    }
}
