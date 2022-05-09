package com.Dao.impl;

import com.Dao.Theme_PostDao;
import com.entity.Person;
import com.entity.Theme_Post;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Theme_PostImpl implements Theme_PostDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addTheme_Post(Theme_Post theme_post) {
        String sql=
                "INSERT INTO theme_post VALUES(?,?,?,?,?,?,?,?)";
        int update=jdbcTemplate.update(sql,theme_post.getTheme_post_id(),theme_post.getTheme_post_title(),
                theme_post.getTheme_post_content(),theme_post.getUser_id(),
                theme_post.getTheme_post_createTime(),
                theme_post.getIs_fine(),theme_post.getIs_top(),theme_post.getTheme_post_lock());
        return update;
    }

    @Override
    public int updateTheme_Post(Theme_Post theme_post) {
        String sql=
                "UPDATE theme_post SET theme_post_content=? WHERE theme_post_id=?";
        int update=jdbcTemplate.update(sql,theme_post.getTheme_post_content(),
                theme_post.getTheme_post_id());
        return update;
    }

    @Override
    public Theme_Post getTheme_PostByTheme_post_id(int theme_post_id) {
        String sql="SELECT * FROM Theme_Post WHERE theme_post_id=?";
        try{
            return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Theme_Post.class),theme_post_id);
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Theme_Post> getTheme_PostAll() {
        String sql="SELECT * FROM Theme_Post WHERE theme_post_lock=0 ORDER BY is_top desc,theme_post_createTime desc";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Theme_Post>(Theme_Post.class));
    }
    public List<Theme_Post> getTheme_PostAllByLock() {
        String sql="SELECT * FROM Theme_Post WHERE theme_post_lock=1 ORDER BY is_top desc,theme_post_createTime desc";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Theme_Post>(Theme_Post.class));
    }
    public List<Theme_Post> getTheme_PostAllByFine(){
        String sql="SELECT * FROM Theme_Post WHERE theme_post_lock=0 AND is_fine=1"+
                " ORDER BY is_top desc,theme_post_createTime desc";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Theme_Post>(Theme_Post.class));
    }
    @Override
    public List<Theme_Post> getTheme_PostByUser_id(int user_id) {
        String sql="SELECT * FROM theme_post WHERE user_id="+user_id;
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Theme_Post>(Theme_Post.class));
    }
    @Override
    public List<Theme_Post> getTheme_PostByTitle(String theme_post_title) {
        String sql="SELECT * FROM theme_post WHERE theme_post_title LIKE '%"+theme_post_title+"%'";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Theme_Post>(Theme_Post.class));
    }
    @Override
    public List<Theme_Post> getTheme_PostByUser_name(String user_name) {
        String sql="SELECT * FROM theme_post WHERE user_id IN " +
                "(SELECT * FROM Person WHERE user_name LIKE '%"+user_name+"%')";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Theme_Post>(Theme_Post.class));
    }

    @Override
    public List<Theme_Post> getTheme_Post_Collected(int user_id) {
        String sql="SELECT theme_collect_list FROM person WHERE user_id="+user_id;
        String theme_collect_list=new String();
        try{
            theme_collect_list= jdbcTemplate.queryForObject(sql,String.class);
            String[] split=theme_collect_list.split(",");
            List<Theme_Post> theme_collect=new ArrayList<>();
            for(String i:split)
            {
                theme_collect.add(getTheme_PostByTheme_post_id(Integer.valueOf(i)));
            }
            return theme_collect;
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public int countTheme_PostNum() {
        String sql = "SELECT COUNT(*) FROM theme_post";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public int deleteTheme_Post(Theme_Post theme_post) {
        String sql="DELETE FROM theme_post WHERE theme_post_id=?";
        return jdbcTemplate.update(sql,theme_post.getTheme_post_id());
    }

}
