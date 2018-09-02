package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 畅均江 on 2018/8/30.
 */
public class Chapter implements Serializable {
    private String id;
    private String name;
    private String duration;
    private String size;
    private String audioPath;
    private Integer album_id;

    public Chapter() {
    }

    public Chapter(String id, String name, String duration, String size, String audioPath, Integer album_id) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.size = size;
        this.audioPath = audioPath;
        this.album_id = album_id;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
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

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", size='" + size + '\'' +
                ", audioPath='" + audioPath + '\'' +
                ", album_id=" + album_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chapter chapter = (Chapter) o;

        if (id != null ? !id.equals(chapter.id) : chapter.id != null) return false;
        if (name != null ? !name.equals(chapter.name) : chapter.name != null) return false;
        if (duration != null ? !duration.equals(chapter.duration) : chapter.duration != null) return false;
        if (size != null ? !size.equals(chapter.size) : chapter.size != null) return false;
        if (audioPath != null ? !audioPath.equals(chapter.audioPath) : chapter.audioPath != null) return false;
        return album_id != null ? album_id.equals(chapter.album_id) : chapter.album_id == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (audioPath != null ? audioPath.hashCode() : 0);
        result = 31 * result + (album_id != null ? album_id.hashCode() : 0);
        return result;
    }
}
