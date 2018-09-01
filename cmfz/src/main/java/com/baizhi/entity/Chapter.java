package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 畅均江 on 2018/8/30.
 */
public class Chapter implements Serializable {
    private String id;
    private String name;
    private Date duration;
    private String size;
    private String audioPath;
    private Integer album_id;

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", size='" + size + '\'' +
                ", audioPath='" + audioPath + '\'' +
                ", album_id=" + album_id +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Chapter(String id, String name, Date duration, String size, String audioPath, Integer album_id) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.size = size;
        this.audioPath = audioPath;
        this.album_id = album_id;
    }

    public Chapter() {
    }
}
