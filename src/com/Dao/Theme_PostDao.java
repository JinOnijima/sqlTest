package com.Dao;

import com.entity.Theme_Post;

import java.util.List;

public interface Theme_PostDao {
    int addTheme_Post(Theme_Post theme_post);
    int updateTheme_Post(Theme_Post theme_post);
    Theme_Post getTheme_PostByTheme_post_id(int theme_post_id);
    List<Theme_Post> getTheme_PostAll();
    List<Theme_Post> getTheme_PostAllByLock();
    List<Theme_Post> getTheme_PostAllByFine();
    List<Theme_Post> getTheme_PostByUser_id(int user_id);
    List<Theme_Post> getTheme_PostByTitle(String theme_post_title);
    List<Theme_Post> getTheme_PostByUser_name(String user_name);
    List<Theme_Post> getTheme_Post_Collected(int user_id);
    int countTheme_PostNum();
    int deleteTheme_Post(Theme_Post theme_post);
}
