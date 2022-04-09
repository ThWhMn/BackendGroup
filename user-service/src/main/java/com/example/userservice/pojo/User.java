package com.example.userservice.pojo;

public class User {
    private String id;
    private String nickname;
    private String phone;
    private String email;
    private String password;
    private String salt;
    private String gmt_create;
    private String gmt_update;

    public User(String id, String nickname, String password) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}