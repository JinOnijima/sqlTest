package com.Dao.impl;

import com.Dao.Reply_PostDao;
import com.entity.Reply_Post;
import com.entity.Theme_Post;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class Reply_PostImpl implements Reply_PostDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addReply_Post(Reply_Post reply_post) {
        String sql=
                "INSERT INTO reply_post VALUES(?,?,?,?,?,?)";
        int update=jdbcTemplate.update(sql,reply_post.getReply_post_id(),reply_post.getUser_id(),
                reply_post.getReply_post_content(),reply_post.getReply_post_createTime(),
                reply_post.getTheme_post_id(),reply_post.getReply_post_lock());
        return update;
    }

    @Override
    public int updateReply_Post(Reply_Post reply_post) {
        String sql=
                "UPDATE reply_post SET reply_post_content=? WHERE reply_post_id=?";
        int update=jdbcTemplate.update(sql,reply_post.getReply_post_content(),
                reply_post.getReply_post_id());
        return update;
    }

    @Override
    public List<Reply_Post> getReply_PostByUser_id(int user_id) {
        String sql="SELECT * FROM reply_post WHERE user_id="+user_id;
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Reply_Post>(Reply_Post.class));
    }

    @Override
    public List<Reply_Post> getReply_PostByTheme_post_id(int theme_post_id) {
        String sql="SELECT * FROM reply_post WHERE theme_post_id="+theme_post_id;
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Reply_Post>(Reply_Post.class));
    }

    @Override
    public int countReply_PostNum() {
        String sql = "SELECT COUNT(*) FROM reply_post";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public int deleteReply_Post(Reply_Post reply_post) {
        String sql="DELETE FROM reply_post WHERE reply_post_id=?";
        return jdbcTemplate.update(sql,reply_post.getReply_post_id());
    }
}
