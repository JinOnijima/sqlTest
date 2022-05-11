package com.service.impl;

import com.Dao.PersonDao;
import com.Dao.Theme_PostDao;
import com.Result.ResultData;
import com.entity.Combine_Theme_Person;
import com.entity.Person;
import com.entity.Theme_Post;
import com.service.Theme_PostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service("theme_postService")
public class Theme_PostServiceImpl implements Theme_PostService {
    @Resource
    private Theme_PostDao theme_postDao;
    @Resource
    private PersonDao personDao;


    @Override
    public int addTheme_Post(Theme_Post theme_post) {
        return theme_postDao.addTheme_Post(theme_post);
    }

    @Override
    public int updateTheme_Post(Theme_Post theme_post) {
        return theme_postDao.updateTheme_Post(theme_post);
    }

    @Override
    public Theme_Post getTheme_PostByTheme_post_id(int theme_post_id) {
        return theme_postDao.getTheme_PostByTheme_post_id(theme_post_id);
    }

    @Override
    public List<Theme_Post> getTheme_PostAll() {
        return theme_postDao.getTheme_PostAll();
    }
    public List<Theme_Post> getTheme_PostAllByLock() {
        return theme_postDao.getTheme_PostAllByLock();
    }

    @Override
    public List<Theme_Post> getTheme_PostAllByFine() {
        return theme_postDao.getTheme_PostAllByFine();
    }

    @Override
    public List<Theme_Post> getTheme_PostByUser_id(int user_id) {
        return theme_postDao.getTheme_PostByUser_id(user_id);
    }

    @Override
    public List<Theme_Post> getTheme_PostByTitle(String theme_post_title) {
        return theme_postDao.getTheme_PostByTitle(theme_post_title);
    }

    @Override
    public List<Theme_Post> getTheme_PostByUser_name(String user_name) {
        return theme_postDao.getTheme_PostByUser_name(user_name);
    }

    @Override
    public Combine_Theme_Person getCombineTP(Theme_Post theme_post) {
        Combine_Theme_Person combine_theme_person=new Combine_Theme_Person();
        combine_theme_person.setTheme_post(theme_post);
        Person person=personDao.getPersonById(theme_post.user_id);
        combine_theme_person.setPerson(person);
        return combine_theme_person;
    }

    @Override
    public List<Combine_Theme_Person> getCombineTPList(List<Theme_Post> theme_posts) {
        List<Combine_Theme_Person> combine_theme_personList=new ArrayList<>();
        for(Theme_Post i:theme_posts)
        {
            Combine_Theme_Person combine_theme_person=
                    getCombineTP(i);
            combine_theme_personList.add(combine_theme_person);
        }
        return combine_theme_personList;
    }

    @Override
    public int countTheme_PostNum() {
        return theme_postDao.countTheme_PostNum();
    }

    @Override
    public int deleteTheme_Post(Theme_Post theme_post) {
        return theme_postDao.deleteTheme_Post(theme_post);
    }

    @Override
    public ResultData ThemeMsg(int theme_post_id) {
        ResultData resultData=new ResultData();
        Theme_Post theme_post=getTheme_PostByTheme_post_id(theme_post_id);
        Combine_Theme_Person combine_theme_person=getCombineTP(theme_post);

        resultData.setStatus(200);
        resultData.setMessage("获取到主题帖信息！");
        resultData.setData(combine_theme_person);
        return resultData;
    }

    @Override
    public ResultData SearchTheme(String theme_post_title) {
        ResultData resultData=new ResultData();
        List<Theme_Post> theme_posts=getTheme_PostByTitle(theme_post_title);
        List<Combine_Theme_Person> combine_theme_personList=getCombineTPList(theme_posts);
        resultData.setStatus(200);
        resultData.setMessage("已返回根据模糊查询获得的全部主题帖");
        resultData.setData(combine_theme_personList);
        return resultData;
    }

    public ResultData ShowThemeAll()
    {
        ResultData resultData=new ResultData();
        List<Theme_Post> theme_posts=getTheme_PostAll();
        List<Combine_Theme_Person> combine_theme_personList=getCombineTPList(theme_posts);
        resultData.setStatus(200);
        resultData.setMessage("已按照置顶帖优先、发帖时间降序的顺序返回全部未锁定的主题帖");
        resultData.setData(combine_theme_personList);
        return resultData;
    }

    @Override
    public ResultData ShowThemeAllByLock() {
        ResultData resultData=new ResultData();
        List<Theme_Post> theme_posts=getTheme_PostAllByLock();
        List<Combine_Theme_Person> combine_theme_personList=getCombineTPList(theme_posts);
        resultData.setStatus(200);
        resultData.setMessage("已按照发帖时间降序的顺序返回全部锁定的主题帖");
        resultData.setData(combine_theme_personList);
        return resultData;
    }

    @Override
    public ResultData ShowThemeAllByFine() {
        ResultData resultData=new ResultData();
        List<Theme_Post> theme_posts=getTheme_PostAllByFine();
        List<Combine_Theme_Person> combine_theme_personList=getCombineTPList(theme_posts);
        resultData.setStatus(200);
        resultData.setMessage("已按照发帖时间降序的顺序返回全部精华主题帖");
        resultData.setData(combine_theme_personList);
        return resultData;
    }

    @Override
    public ResultData ShowThemeCollected(int user_id) {
        ResultData resultData=new ResultData();
        List<Theme_Post> theme_posts=theme_postDao.getTheme_Post_Collected(user_id);
        List<Combine_Theme_Person> combine_theme_personList=getCombineTPList(theme_posts);
        resultData.setStatus(200);
        resultData.setMessage("已返回该用户收藏的主题帖信息");
        resultData.setData(combine_theme_personList);
        return resultData;
    }

    @Override
    public ResultData ShowThemeAllByUser_id(int user_id) {
        ResultData resultData=new ResultData();
        List<Theme_Post> theme_posts=getTheme_PostByUser_id(user_id);
        List<Combine_Theme_Person> combine_theme_personList=getCombineTPList(theme_posts);
        resultData.setStatus(200);
        resultData.setMessage("已返回该用户发布的主题帖信息");
        resultData.setData(combine_theme_personList);
        return resultData;
    }

    @Override
    public ResultData AddNewTheme(String theme_post_title, String theme_post_content, int user_id) {
        ResultData resultData =new ResultData();

        Theme_Post theme_post=new Theme_Post();
        theme_post.setTheme_post_id(countTheme_PostNum()+1);
        theme_post.setTheme_post_title(theme_post_title);
        theme_post.setTheme_post_content(theme_post_content);
        theme_post.setUser_id(user_id);
        theme_post.setTheme_post_createTime(new Timestamp(System.currentTimeMillis()));
        theme_post.setIs_fine(0);
        theme_post.setIs_top(0);
        theme_post.setTheme_post_lock(1);//新主题帖需要经过审核才能发出
        addTheme_Post(theme_post);
        Combine_Theme_Person combine_theme_person=getCombineTP(theme_post);

        resultData.setStatus(200);
        resultData.setMessage("已发送主题帖，请等待管理员审核");
        resultData.setData(combine_theme_person);
        return resultData;
    }
    public ResultData UnlockTheme(int theme_post_id)
    {
        ResultData resultData=new ResultData();
        Theme_Post theme_post=getTheme_PostByTheme_post_id(theme_post_id);
        theme_post.setTheme_post_lock(0);
        updateTheme_Post(theme_post);
        Combine_Theme_Person combine_theme_person=getCombineTP(theme_post);

        resultData.setStatus(200);
        resultData.setMessage("已解锁该主题帖");
        resultData.setData(combine_theme_person);
        return resultData;
    }

    @Override
    public ResultData LockTheme(int theme_post_id)
    {
        ResultData resultData=new ResultData();
        Theme_Post theme_post=getTheme_PostByTheme_post_id(theme_post_id);
        theme_post.setTheme_post_lock(1);
        updateTheme_Post(theme_post);
        Combine_Theme_Person combine_theme_person=getCombineTP(theme_post);

        resultData.setStatus(200);
        resultData.setMessage("已锁定该主题帖");
        resultData.setData(combine_theme_person);
        return resultData;
    }

    @Override
    public ResultData SetFineTheme(int theme_post_id)
    {
        ResultData resultData=new ResultData();
        Theme_Post theme_post=getTheme_PostByTheme_post_id(theme_post_id);
        theme_post.setIs_fine(1);
        updateTheme_Post(theme_post);
        Combine_Theme_Person combine_theme_person=getCombineTP(theme_post);

        resultData.setStatus(200);
        resultData.setMessage("已将该主题帖设为精华");
        resultData.setData(combine_theme_person);
        return resultData;
    }

    @Override
    public ResultData CancelFineTheme(int theme_post_id)
    {
        ResultData resultData=new ResultData();
        Theme_Post theme_post=getTheme_PostByTheme_post_id(theme_post_id);
        theme_post.setIs_fine(0);
        updateTheme_Post(theme_post);
        Combine_Theme_Person combine_theme_person=getCombineTP(theme_post);

        resultData.setStatus(200);
        resultData.setMessage("已将该主题帖取消精华");
        resultData.setData(combine_theme_person);
        return resultData;
    }

    @Override
    public ResultData SetTopTheme(int theme_post_id)
    {
        ResultData resultData=new ResultData();
        Theme_Post theme_post=getTheme_PostByTheme_post_id(theme_post_id);
        theme_post.setIs_top(1);
        updateTheme_Post(theme_post);
        Combine_Theme_Person combine_theme_person=getCombineTP(theme_post);

        resultData.setStatus(200);
        resultData.setMessage("已将该主题帖设为置顶");
        resultData.setData(combine_theme_person);
        return resultData;
    }

    @Override
    public ResultData CancelTopTheme(int theme_post_id)
    {
        ResultData resultData=new ResultData();
        Theme_Post theme_post=getTheme_PostByTheme_post_id(theme_post_id);
        theme_post.setIs_top(0);
        updateTheme_Post(theme_post);
        Combine_Theme_Person combine_theme_person=getCombineTP(theme_post);

        resultData.setStatus(200);
        resultData.setMessage("已将该主题帖取消置顶");
        resultData.setData(combine_theme_person);
        return resultData;
    }
}
