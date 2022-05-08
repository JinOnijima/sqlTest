package com.entity;

import org.springframework.jdbc.core.JdbcTemplate;

public class Person {
    public int user_id;
    public String user_name;
    public String user_password;
    public int user_sex;
    public int user_age;
    public String user_pro;
    public String user_hobby;
    public String following_list;
    public String fan_list;
    public int following_num;
    public int fan_num;
    public int user_lock;
    public String theme_collect_list;
    public int is_manager;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public int getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(int user_sex) {
        this.user_sex = user_sex;
    }

    public int getUser_age() {
        return user_age;
    }

    public void setUser_age(int user_age) {
        this.user_age = user_age;
    }

    public String getUser_pro() {
        return user_pro;
    }

    public void setUser_pro(String user_pro) {
        this.user_pro = user_pro;
    }

    public String getUser_hobby() {
        return user_hobby;
    }

    public void setUser_hobby(String user_hobby) {
        this.user_hobby = user_hobby;
    }

    public String getFollowing_list() {
        return following_list;
    }

    public void setFollowing_list(String following_list) {
        this.following_list = following_list;
    }

    public String getFan_list() {
        return fan_list;
    }

    public void setFan_list(String fan_list) {
        this.fan_list = fan_list;
    }

    public int getFollowing_num() {
        return following_num;
    }

    public void setFollowing_num(int following_num) {
        this.following_num = following_num;
    }

    public int getFan_num() {
        return fan_num;
    }

    public void setFan_num(int fan_num) {
        this.fan_num = fan_num;
    }

    public int getUser_lock() {
        return user_lock;
    }

    public void setUser_lock(int user_lock) {
        this.user_lock = user_lock;
    }

    public String getTheme_collect_list() {
        return theme_collect_list;
    }

    public void setTheme_collect_list(String theme_collect_list) {
        this.theme_collect_list = theme_collect_list;
    }

    public int getIs_manager() {
        return is_manager;
    }

    public void setIs_manager(int is_manager) {
        this.is_manager = is_manager;
    }

    @Override
    public String toString() {
        return "Person{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_sex=" + user_sex +
                ", user_age=" + user_age +
                ", user_pro='" + user_pro + '\'' +
                ", user_hobby='" + user_hobby + '\'' +
                ", following_list='" + following_list + '\'' +
                ", fan_list='" + fan_list + '\'' +
                ", following_num=" + following_num +
                ", fan_num=" + fan_num +
                ", user_lock=" + user_lock +
                ", theme_collect_list='" + theme_collect_list + '\'' +
                ", is_manager=" + is_manager +
                '}';
    }
}
