package com.entity;

import java.sql.Timestamp;

public class Reply_Post {
    public int reply_post_id;
    public int user_id;
    public String reply_post_content;
    public Timestamp reply_post_createTime;
    public int theme_post_id;
    public int reply_post_lock;

    public int getReply_post_id() {
        return reply_post_id;
    }

    public void setReply_post_id(int reply_post_id) {
        this.reply_post_id = reply_post_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getReply_post_content() {
        return reply_post_content;
    }

    public void setReply_post_content(String reply_post_content) {
        this.reply_post_content = reply_post_content;
    }

    public Timestamp getReply_post_createTime() {
        return reply_post_createTime;
    }

    public void setReply_post_createTime(Timestamp reply_post_createTime) {
        this.reply_post_createTime = reply_post_createTime;
    }

    public int getTheme_post_id() {
        return theme_post_id;
    }

    public void setTheme_post_id(int theme_post_id) {
        this.theme_post_id = theme_post_id;
    }

    public int getReply_post_lock() {
        return reply_post_lock;
    }

    public void setReply_post_lock(int reply_post_lock) {
        this.reply_post_lock = reply_post_lock;
    }

    @Override
    public String toString() {
        return "Reply_Post{" +
                "reply_post_id=" + reply_post_id +
                ", user_id=" + user_id +
                ", reply_post_content='" + reply_post_content + '\'' +
                ", reply_post_createTime=" + reply_post_createTime +
                ", theme_post_id=" + theme_post_id +
                ", reply_post_lock=" + reply_post_lock +
                '}';
    }
}
