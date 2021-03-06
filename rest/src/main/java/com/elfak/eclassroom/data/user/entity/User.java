package com.elfak.eclassroom.data.user.entity;

import com.elfak.eclassroom.data.base.entity.Base;
import com.elfak.eclassroom.data.lecture.entity.Lecture;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "system_user")
public class User extends Base {

    @Column
    private String fullName;

    @Column
    private String email;

    @OneToMany(mappedBy = "tutor")
    @Cascade(value = {org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
    private Set<Lecture> lectures;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(Set<Lecture> lectures) {
        this.lectures = lectures;
    }
}
