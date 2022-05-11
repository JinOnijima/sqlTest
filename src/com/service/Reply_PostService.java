package com.service;

import com.Result.ResultData;
import com.entity.Combine_Reply_Person;
import com.entity.Reply_Post;

import java.util.List;

public interface Reply_PostService {
    int addReply_Post(Reply_Post reply_post);
    int updateReply_Post(Reply_Post reply_post);
    Reply_Post getReply_PostById(int reply_post_id);
    List<Reply_Post> getReply_PostByUser_id(int user_id);
    List<Reply_Post> getReply_PostByTheme_post_id(int theme_post_id);
    Combine_Reply_Person getCombineRP(Reply_Post reply_post);
    List<Combine_Reply_Person> getCombineRPList(List<Reply_Post> reply_posts);
    int countReply_PostNum();
    int deleteReply_Post(Reply_Post reply_post);

    ResultData ReplyMsg(int reply_post_id);
    ResultData AddNewReply(int theme_post_id,int user_id,String reply_post_content);
    ResultData ShowReplyAllByUser_id(int user_id);
    ResultData ShowReplyAllByTheme(int theme_post_id);
    ResultData LockReply(int reply_post_id);
}
