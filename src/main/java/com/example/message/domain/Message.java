package com.example.message.domain;

import java.util.Date;

/**
 * 留言类
 */
public class Message {

    int id;

    String name;

    String phone;

    String content;

    Date time;


    public Message(String name, String phone, String content) {
        this.name = name;
        this.phone = phone;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
