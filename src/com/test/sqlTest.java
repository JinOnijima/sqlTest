package com.test;

import com.Result.ResultData;
import com.entity.Person;
import com.entity.Reply_Post;
import com.entity.Theme_Post;
import com.service.PersonService;
import com.service.Reply_PostService;
import com.service.Theme_PostService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.List;

public class sqlTest {
    public static void main(String args[])throws Exception{
        ApplicationContext applicationContext=new
                ClassPathXmlApplicationContext("applicationContent.xml");
        PersonService personService =applicationContext.getBean("personService", PersonService.class);
        Theme_PostService theme_postService=
                applicationContext.getBean("theme_postService",Theme_PostService.class);
        Reply_PostService reply_postService=
                applicationContext.getBean("reply_postService",Reply_PostService.class);
        /*
        添加新用户
        Person person1 =new Person();
        int tempId=personService.countPersonNum()+1;
        person1.setUser_id(tempId);
        person1.setUser_name("呃呃3号");
        person1.setUser_password("abc123");
        person1.setUser_sex(1);
        person1.setUser_age(17);
        person1.setUser_pro("吟游诗人");
        person1.setUser_hobby("吹口哨");
        person1.setFollowing_list("");
        person1.setFan_list("");
        person1.setFollowing_num(0);
        person1.setFan_num(0);
        person1.setUser_lock(0);
        int temp= personService.addPerson(person1);
        */
        /*
        修改用户信息
        Person person2=personService.getPerson(4);
        person2.setUser_password("我是成龙");
        int temp2= personService.updatePerson(person2);

         */
        /*
        根据用户名查询用户

        ResultData resultData=new ResultData();
        Person person=personService.getPersonByName("ee");
        if(person==null||!person.getUser_password().equals("abc123"))
        {
            resultData.setStatus(400);
            resultData.setMessage("登录失败，用户不存在或密码错误！");
        }else{
            resultData.setStatus(200);
            resultData.setMessage("登录成功！");
        }
        System.out.print(resultData);*/
        /*
        关注用户

        personService.FollowPerson(3,5); */
        /*
        收藏主题

        personService.CollectTheme(3,3);*/
        /*
        获得全部主题

        List<Theme_Post> theme_posts=theme_postService.getTheme_PostAll();
        for(Theme_Post i:theme_posts)
        {
            System.out.println(i);
        }*/

        /*
        添加新主题

        Person person3=personService.getPersonById(1);
        Theme_Post theme_post1=new Theme_Post();
        theme_post1.setTheme_post_id(theme_postService.countTheme_PostNum()+1);
        theme_post1.setTheme_post_title("我的第三个主题帖");
        theme_post1.setTheme_post_content("我恨你们！");
        theme_post1.setUser_id(person3.getUser_id());
        theme_post1.setTheme_post_createTime(new Timestamp(System.currentTimeMillis()));
        theme_post1.setIs_fine(0);
        theme_post1.setIs_top(0);
        theme_post1.setTheme_post_lock(0);
        theme_postService.addTheme_Post(theme_post1);
*/
        /*关键词模糊查询主题帖
        *
        String str="第一个";
        List<Theme_Post> theme_post2=theme_postService.getTheme_PostByTitle(str);
        for(Theme_Post i:theme_post2)
        {
            System.out.println(i);
        }*/
        /*
        回复第一个主题帖
        Person person4=personService.getPerson(4);
        Theme_Post theme_post1=theme_postService.getTheme_PostByTheme_post_id(1);
        Reply_Post reply_post1=new Reply_Post();
        reply_post1.setReply_post_id(reply_postService.countReply_PostNum()+1);
        reply_post1.setUser_id(person4.getUser_id());
        reply_post1.setReply_post_content("我的第一条评论");
        reply_post1.setReply_post_createTime(new Timestamp((System.currentTimeMillis())));
        reply_post1.setTheme_post_id(theme_post1.getTheme_post_id());
        reply_post1.setReply_post_lock(0);
        reply_postService.addReply_Post(reply_post1);

         */
        /*
        获得一个主题帖的全部回复

        Theme_Post theme_post1=theme_postService.getTheme_PostByTheme_post_id(1);
        List<Reply_Post> reply_posts=
                reply_postService.getReply_PostByTheme_post_id(theme_post1.getTheme_post_id());
        for(Reply_Post i:reply_posts)
        {
            System.out.println(i);
        }*/

    }
}
