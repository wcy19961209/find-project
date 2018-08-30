package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by 畅均江 on 2018/8/30.
 */
public class Album implements Serializable{
    private Integer id;
    private String title;
    private  Integer count;
    private String corverlmg;
    private double score;
    private  String author;
    private String broadCast;
    private  String brife;
    private Date publicDate;
    private Date createDate;
    private List<Chapter> chapter;


    public Album() {
    }

    public Album(Integer id, String title, Integer count, String corverlmg, double score, String author, String broadCast, String brife, Date publicDate, Date createDate, List<Chapter> chapter) {
        this.id = id;
        this.title = title;
        this.count = count;
        this.corverlmg = corverlmg;
        this.score = score;
        this.author = author;
        this.broadCast = broadCast;
        this.brife = brife;
        this.publicDate = publicDate;
        this.createDate = createDate;
        this.chapter = chapter;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCorverlmg() {
        return corverlmg;
    }

    public void setCorverlmg(String corverlmg) {
        this.corverlmg = corverlmg;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadCast() {
        return broadCast;
    }

    public void setBroadCast(String broadCast) {
        this.broadCast = broadCast;
    }

    public String getBrife() {
        return brife;
    }

    public void setBrife(String brife) {
        this.brife = brife;
    }

    public Date getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<Chapter> getChapter() {
        return chapter;
    }

    public void setChapter(List<Chapter> chapter) {
        this.chapter = chapter;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", count=" + count +
                ", corverlmg='" + corverlmg + '\'' +
                ", score=" + score +
                ", author='" + author + '\'' +
                ", broadCast='" + broadCast + '\'' +
                ", brife='" + brife + '\'' +
                ", publicDate=" + publicDate +
                ", createDate=" + createDate +
                ", chapter=" + chapter +
                '}';
    }
}
