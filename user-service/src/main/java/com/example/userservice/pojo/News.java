package com.example.userservice.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

public class News {
    private String id;
    private String title;
    private String type;
    @JsonProperty("userId")
    private String user_id;
    private String link;
    private String cover;
    private String downloads;
    @JsonProperty("gmtCreate")
    private String gmt_create;
    @JsonProperty("createBy")
    private String create_by;
    @JsonProperty("gmtUpdate")
    private String gmt_update;
    @JsonProperty("updateBy")
    private String update_by;
    private String[] columns = new String[] { "id", "title", "type", "user_id", "link", "cover", "downloads",
            "gmt_create",
            "create_by", "gmt_update", "update_by" };

    public News() {}

    public News(String msg) {
        String[] m = msg.split(",");
        id = m[0];
        title = m[1];
        type = m[2];
        user_id = m[3];
        link = m[4];
        cover = m[5];
        downloads = m[6];
        create_by = m[7];
        update_by = m[8];
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        gmt_create = sdf.format(date);
        gmt_update = gmt_create;
    }


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getUserId() {
        return user_id;
    }

    public String getLink() {
        return link;
    }

    public String getCover() {
        return cover;
    }

    public String getDownloads() {
        return downloads;
    }

    public String getGmtCreate() {
        return gmt_create;
    }

    public String getCreateBy() {
        return create_by;
    }

    public String getGmtUpdate() {
        return gmt_update;
    }

    public String getUpdateBy() {
        return update_by;
    }

    @Override
    public String toString() {
        return getId()+" "+getTitle()+" "+getType()+" "+getUserId()+" "+getLink()+" "+getCover()+" "+
               getDownloads()+" "+getGmtCreate()+" "+getCreateBy()+" "+getGmtUpdate()+" "+getUpdateBy();
    }
}

