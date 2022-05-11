package com.service;

import com.Result.ResultData;
import com.entity.Combine_Theme_Person;
import com.entity.Theme_Post;

import java.util.List;

public interface Theme_PostService {
    int addTheme_Post(Theme_Post theme_post);
    int updateTheme_Post(Theme_Post theme_post);
    Theme_Post getTheme_PostByTheme_post_id(int theme_post_id);
    List<Theme_Post> getTheme_PostAll();
    List<Theme_Post> getTheme_PostAllByLock();
    List<Theme_Post> getTheme_PostAllByFine();
    List<Theme_Post> getTheme_PostByUser_id(int user_id);
    List<Theme_Post> getTheme_PostByTitle(String theme_post_title);
    List<Theme_Post> getTheme_PostByUser_name(String user_name);
    Combine_Theme_Person getCombineTP(Theme_Post theme_post);
    List<Combine_Theme_Person> getCombineTPList(List<Theme_Post> theme_posts);
    int countTheme_PostNum();
    int deleteTheme_Post(Theme_Post theme_post);

    ResultData ThemeMsg(int theme_post_id);
    ResultData SearchTheme(String theme_post_title);
    ResultData ShowThemeAll();
    ResultData ShowThemeAllByLock();
    ResultData ShowThemeAllByFine();
    ResultData ShowThemeCollected(int user_id);
    ResultData ShowThemeAllByUser_id(int user_id);
    ResultData AddNewTheme(String theme_post_title,String theme_post_content,int user_id);
    ResultData UnlockTheme(int theme_post_id);
    ResultData LockTheme(int theme_post_id);
    ResultData SetFineTheme(int theme_post_id);
    ResultData CancelFineTheme(int theme_post_id);
    ResultData SetTopTheme(int theme_post_id);
    ResultData CancelTopTheme(int theme_post_id);
}
