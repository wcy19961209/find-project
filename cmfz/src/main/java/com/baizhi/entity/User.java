package com.baizhi.entity;

import java.util.Date;

/**
 * Created by 畅均江 on 2018/9/3.
 */
public class User {
    private Integer id;
    private String photoimg;
    private String name;
    private String dharmaName;
    private String sex;
    private String province;
    private String city;
    private String sign;
    private String phoneNum;
    private String password;
    private String salt;
    private String status;
    private Date regisDate;
    private Integer guru_id;

    public User() {
    }

    public User(Integer id, String photoimg, String name, String dharmaName, String sex, String province, String city, String sign, String phoneNum, String password, String salt, String status, Date regisDate, Integer guru_id) {
        this.id = id;
        this.photoimg = photoimg;
        this.name = name;
        this.dharmaName = dharmaName;
        this.sex = sex;
        this.province = province;
        this.city = city;
        this.sign = sign;
        this.phoneNum = phoneNum;
        this.password = password;
        this.salt = salt;
        this.status = status;
        this.regisDate = regisDate;
        this.guru_id = guru_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhotoimg() {
        return photoimg;
    }

    public void setPhotoimg(String photoimg) {
        this.photoimg = photoimg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDharmaName() {
        return dharmaName;
    }

    public void setDharmaName(String dharmaName) {
        this.dharmaName = dharmaName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRegisDate() {
        return regisDate;
    }

    public void setRegisDate(Date regisDate) {
        this.regisDate = regisDate;
    }

    public Integer getGuru_id() {
        return guru_id;
    }

    public void setGuru_id(Integer guru_id) {
        this.guru_id = guru_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", photoimg='" + photoimg + '\'' +
                ", name='" + name + '\'' +
                ", dharmaName='" + dharmaName + '\'' +
                ", sex='" + sex + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", sign='" + sign + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", status='" + status + '\'' +
                ", regisDate=" + regisDate +
                ", guru_id=" + guru_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (photoimg != null ? !photoimg.equals(user.photoimg) : user.photoimg != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (dharmaName != null ? !dharmaName.equals(user.dharmaName) : user.dharmaName != null) return false;
        if (sex != null ? !sex.equals(user.sex) : user.sex != null) return false;
        if (province != null ? !province.equals(user.province) : user.province != null) return false;
        if (city != null ? !city.equals(user.city) : user.city != null) return false;
        if (sign != null ? !sign.equals(user.sign) : user.sign != null) return false;
        if (phoneNum != null ? !phoneNum.equals(user.phoneNum) : user.phoneNum != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (salt != null ? !salt.equals(user.salt) : user.salt != null) return false;
        if (status != null ? !status.equals(user.status) : user.status != null) return false;
        if (regisDate != null ? !regisDate.equals(user.regisDate) : user.regisDate != null) return false;
        return guru_id != null ? guru_id.equals(user.guru_id) : user.guru_id == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (photoimg != null ? photoimg.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dharmaName != null ? dharmaName.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (sign != null ? sign.hashCode() : 0);
        result = 31 * result + (phoneNum != null ? phoneNum.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (regisDate != null ? regisDate.hashCode() : 0);
        result = 31 * result + (guru_id != null ? guru_id.hashCode() : 0);
        return result;
    }
}
