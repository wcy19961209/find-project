package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by 畅均江 on 2018/8/30.
 */
public class Album implements Serializable{
    private Integer id;
    private String name;
    private  Integer count;
    private String corverlmg;
    private double score;
    private  String author;
    private String broadCast;
    private  String brife;
    private Date publicDate;
    private Date createDate;
    private String status;
    private List<Chapter> children;


    public Album() {
    }

    public Album(Integer id, String name, Integer count, String corverlmg, double score, String author, String broadCast, String brife, Date publicDate, Date createDate, String status, List<Chapter> children) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.corverlmg = corverlmg;
        this.score = score;
        this.author = author;
        this.broadCast = broadCast;
        this.brife = brife;
        this.publicDate = publicDate;
        this.createDate = createDate;
        this.status = status;
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", corverlmg='" + corverlmg + '\'' +
                ", score=" + score +
                ", author='" + author + '\'' +
                ", broadCast='" + broadCast + '\'' +
                ", brife='" + brife + '\'' +
                ", publicDate=" + publicDate +
                ", createDate=" + createDate +
                ", status='" + status + '\'' +
                ", children=" + children +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Album album = (Album) o;

        if (Double.compare(album.score, score) != 0) return false;
        if (id != null ? !id.equals(album.id) : album.id != null) return false;
        if (name != null ? !name.equals(album.name) : album.name != null) return false;
        if (count != null ? !count.equals(album.count) : album.count != null) return false;
        if (corverlmg != null ? !corverlmg.equals(album.corverlmg) : album.corverlmg != null) return false;
        if (author != null ? !author.equals(album.author) : album.author != null) return false;
        if (broadCast != null ? !broadCast.equals(album.broadCast) : album.broadCast != null) return false;
        if (brife != null ? !brife.equals(album.brife) : album.brife != null) return false;
        if (publicDate != null ? !publicDate.equals(album.publicDate) : album.publicDate != null) return false;
        if (createDate != null ? !createDate.equals(album.createDate) : album.createDate != null) return false;
        if (status != null ? !status.equals(album.status) : album.status != null) return false;
        return children != null ? children.equals(album.children) : album.children == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (corverlmg != null ? corverlmg.hashCode() : 0);
        temp = Double.doubleToLongBits(score);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (broadCast != null ? broadCast.hashCode() : 0);
        result = 31 * result + (brife != null ? brife.hashCode() : 0);
        result = 31 * result + (publicDate != null ? publicDate.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (children != null ? children.hashCode() : 0);
        return result;
    }
}
