package com.sunzequn.geonames.plus.bean;


import java.util.Date;

/**
 * Created by sloriac on 16-12-6.
 */
public class Feedback {

    private int id;
    private Date time;
    private String content;
    private int status;

    public Feedback() {
    }

    public Feedback(int id, Date time, String content, int status) {
        this.id = id;
        this.time = time;
        this.content = content;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
