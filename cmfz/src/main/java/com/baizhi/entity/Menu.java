package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 畅均江 on 2018/8/29.
 */
public class Menu implements Serializable {
    private Integer id;
    private String title;
    private String content;
    private String href ;
    private String iconCls;
    private String parntid;
    private List<Menu> menu;

    public Menu() {
    }

    public Menu(Integer id, String title, String content, String href, String iconCls, String parntid, List<Menu> menu) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.href = href;
        this.iconCls = iconCls;
        this.parntid = parntid;
        this.menu = menu;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getParntid() {
        return parntid;
    }

    public void setParntid(String parntid) {
        this.parntid = parntid;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", href='" + href + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", parntid='" + parntid + '\'' +
                ", menu=" + menu +
                '}';
    }
}
