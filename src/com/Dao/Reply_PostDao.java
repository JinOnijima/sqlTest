package com.Dao;

import com.entity.Reply_Post;
import com.entity.Theme_Post;

import java.util.List;

public interface Reply_PostDao {
    int addReply_Post(Reply_Post reply_post);
    int updateReply_Post(Reply_Post reply_post);
    Reply_Post getReply_PostById(int reply_post_id);
    List<Reply_Post> getReply_PostByUser_id(int user_id);
    List<Reply_Post> getReply_PostByTheme_post_id(int theme_post_id);
    int countReply_PostNum();
    int deleteReply_Post(Reply_Post reply_post);
}
