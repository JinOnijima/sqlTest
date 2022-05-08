package com.service.impl;

import com.Dao.Reply_PostDao;
import com.Result.ResultData;
import com.entity.Reply_Post;
import com.service.Reply_PostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@Service("reply_postService")
public class Reply_PostServiceImpl implements Reply_PostService {
    @Resource
    private Reply_PostDao reply_postDao;

    @Override
    public int addReply_Post(Reply_Post reply_post) {
        return reply_postDao.addReply_Post(reply_post);
    }

    @Override
    public int updateReply_Post(Reply_Post reply_post) {
        return reply_postDao.updateReply_Post(reply_post);
    }

    @Override
    public List<Reply_Post> getReply_PostByUser_id(int user_id) {
        return reply_postDao.getReply_PostByUser_id(user_id);
    }

    @Override
    public List<Reply_Post> getReply_PostByTheme_post_id(int theme_post_id) {
        return reply_postDao.getReply_PostByTheme_post_id(theme_post_id);
    }

    @Override
    public int countReply_PostNum() {
        return reply_postDao.countReply_PostNum();
    }

    @Override
    public int deleteReply_Post(Reply_Post reply_post) {
        return reply_postDao.deleteReply_Post(reply_post);
    }

    @Override
    public ResultData AddNewReply(int theme_post_id, int user_id, String reply_post_content) {
        ResultData resultData=new ResultData();
        Reply_Post reply_post=new Reply_Post();
        reply_post.setReply_post_id(countReply_PostNum()+1);
        reply_post.setUser_id(user_id);
        reply_post.setReply_post_content(reply_post_content);
        reply_post.setReply_post_createTime(new Timestamp(System.currentTimeMillis()));
        reply_post.setTheme_post_id(theme_post_id);
        reply_post.setReply_post_lock(0);
        addReply_Post(reply_post);

        resultData.setStatus(200);
        resultData.setMessage("成功发送回复！");
        resultData.setData(reply_post);
        return resultData;
    }

    @Override
    public ResultData ShowReplyAllByTheme(int theme_post_id) {
        ResultData resultData=new ResultData();
        List<Reply_Post> reply_posts=getReply_PostByTheme_post_id(theme_post_id);
        resultData.setStatus(200);
        resultData.setMessage("已返回主题帖全部回复！");
        resultData.setData(reply_posts);
        return resultData;
    }
}
