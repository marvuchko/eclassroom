package com.elfak.eclassroom.data.config;

import com.elfak.eclassroom.data.lecture.entity.Lecture;
import com.elfak.eclassroom.data.lecture.entity.VideoThread;
import com.elfak.eclassroom.data.lecture.entity.VideoThreadMessage;
import com.elfak.eclassroom.data.lecture.entity.Video;
import com.elfak.eclassroom.data.user.entity.User;
import org.hibernate.cfg.Configuration;

public class HibernateAnnotatedClasses {

    private HibernateAnnotatedClasses() {
        super();
    }

    public static Configuration setAnnotatedClasses(Configuration configuration) {
        configuration.addAnnotatedClass(Video.class);
        configuration.addAnnotatedClass(Lecture.class);
        configuration.addAnnotatedClass(VideoThread.class);
        configuration.addAnnotatedClass(VideoThreadMessage.class);
        configuration.addAnnotatedClass(User.class);
        return  configuration;
    }

}
