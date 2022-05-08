package com.service;

import com.Result.ResultData;
import com.entity.Reply_Post;

import java.util.List;

public interface Reply_PostService {
    int addReply_Post(Reply_Post reply_post);
    int updateReply_Post(Reply_Post reply_post);
    List<Reply_Post> getReply_PostByUser_id(int user_id);
    List<Reply_Post> getReply_PostByTheme_post_id(int theme_post_id);
    int countReply_PostNum();
    int deleteReply_Post(Reply_Post reply_post);

    ResultData AddNewReply(int theme_post_id,int user_id,String reply_post_content);
    ResultData ShowReplyAllByTheme(int theme_post_id);
}
