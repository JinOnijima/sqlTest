package com.entity;

import java.sql.Timestamp;

public class Theme_Post {
    public int theme_post_id;
    public String theme_post_title;
    public String theme_post_content;
    public int user_id;
    public Timestamp theme_post_createTime;
    public int is_fine;
    public int is_top;
    public int theme_post_lock;

    public int getTheme_post_id() {
        return theme_post_id;
    }

    public void setTheme_post_id(int theme_post_id) {
        this.theme_post_id = theme_post_id;
    }

    public String getTheme_post_title() {
        return theme_post_title;
    }

    public void setTheme_post_title(String theme_post_title) {
        this.theme_post_title = theme_post_title;
    }

    public String getTheme_post_content() {
        return theme_post_content;
    }

    public void setTheme_post_content(String theme_post_content) {
        this.theme_post_content = theme_post_content;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Timestamp getTheme_post_createTime() {
        return theme_post_createTime;
    }

    public void setTheme_post_createTime(Timestamp theme_post_createTime) {
        this.theme_post_createTime = theme_post_createTime;
    }


    public int getIs_fine() {
        return is_fine;
    }

    public void setIs_fine(int is_fine) {
        this.is_fine = is_fine;
    }

    public int getIs_top() {
        return is_top;
    }

    public void setIs_top(int is_top) {
        this.is_top = is_top;
    }

    public int getTheme_post_lock() {
        return theme_post_lock;
    }

    public void setTheme_post_lock(int theme_post_lock) {
        this.theme_post_lock = theme_post_lock;
    }

    @Override
    public String toString() {
        return "Theme_Post{" +
                "theme_post_id=" + theme_post_id +
                ", theme_post_title='" + theme_post_title + '\'' +
                ", theme_post_content='" + theme_post_content + '\'' +
                ", user_id=" + user_id +
                ", theme_post_createTime=" + theme_post_createTime +
                ", is_fine=" + is_fine +
                ", is_top=" + is_top +
                ", theme_post_lock=" + theme_post_lock +
                '}';
    }
}
