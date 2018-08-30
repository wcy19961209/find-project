package com.baizhi.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by 畅均江 on 2018/8/29.
 */
public class Banner implements Serializable {
    private Integer id;
    private String imgPath;
    private String description;
    private String status;
    private Date createDate;
    private String title;

    public Banner() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Banner(Integer id, String imgPath, String description, String status, Date createDate, String title) {
        this.id = id;
        this.imgPath = imgPath;
        this.description = description;
        this.status = status;
        this.createDate = createDate;
        this.title = title;
    }

}
