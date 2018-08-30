package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 畅均江 on 2018/8/30.
 */
public class Chapter implements Serializable {
    private Integer id;
    private String title;
    private Date duration;
    private String size;
    private String audioPath;
    private Integer album_id;

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", size='" + size + '\'' +
                ", audioPath='" + audioPath + '\'' +
                ", album_id=" + album_id +
                '}';
    }

    public Chapter() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath;
    }

    public Integer getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(Integer album_id) {
        this.album_id = album_id;
    }

    public Chapter(Integer id, String title, Date duration, String size, String audioPath, Integer album_id) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.size = size;
        this.audioPath = audioPath;
        this.album_id = album_id;
    }
}
