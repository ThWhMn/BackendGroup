package com.example.springbootmybatis.entity;

public class User {
    private String id;
    private String nickname;
    private String phone;
    private String email;
    private String password;
    private String salt;
    private String gmt_create;
    private String gmt_update;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    // 接口返回的结果是通过getSth()这样的函数来确定的，数据名称则是Sth
    // public String sthuseless() {
    //     return name + address;
    // }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}