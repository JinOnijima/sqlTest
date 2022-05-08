package com.service.impl;

import com.Dao.PersonDao;
import com.Dao.Theme_PostDao;
import com.Result.ResultData;
import com.entity.Person;
import com.entity.Theme_Post;
import com.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("personService")
public class PersonServiceImpl implements PersonService {
    @Resource
    private PersonDao personDao;
    @Override
    public int addPerson(Person person) {
        return personDao.addPerson(person);
    }
    public int updatePerson(Person person){
        return  personDao.updatePerson(person);
    }
    @Override
    public Person getPersonById(int user_id) {
        return personDao.getPersonById(user_id);
    }

    @Override
    public Person getPersonByName(String user_name) {
        return personDao.getPersonByName(user_name);
    }

    @Override
    public List<Person> getPersonAllByLock() {
        return personDao.getPersonAllByLock();
    }

    @Override
    public int countPersonNum() {
        return personDao.countPersonNum();
    }
    @Override
    public int deletePerson(Person person) {
        return personDao.deletePerson(person);
    }

    @Override
    public int checkIs_Followed(int user_id, int follow_id) {
        List<Integer> follow_list=personDao.getFollowingList(user_id);
        if(follow_list!=null)
        {
            for(int i:follow_list)
            {
                if(i==follow_id)
                    return 1;
            }
        }
        return 0;
    }

    @Override
    public int checkIs_Collected(int user_id, int theme_post_id) {
        List<Integer> theme_list=personDao.getThemeCollectList(user_id);
        if(theme_list!=null)
        {
            for(int i:theme_list)
            {
                if(i==theme_post_id)
                    return 1;
            }
        }
        return 0;
    }

    @Override
    public ResultData Register(String user_name, String user_password, int user_sex, int user_age,String user_pro, String user_hobby) {
        ResultData resultData=new ResultData();
        if(getPersonByName(user_name)==null)
        {
            Person person=new Person();
            int tempId=countPersonNum()+1;
            person.setUser_id(tempId);
            person.setUser_name(user_name);
            person.setUser_password(user_password);
            person.setUser_sex(user_sex);
            person.setUser_age(user_age);
            person.setUser_pro(user_pro);
            person.setUser_hobby(user_hobby);
            person.setFollowing_list("");
            person.setFan_list("");
            person.setFollowing_num(0);
            person.setFan_num(0);
            person.setUser_lock(0);
            person.setTheme_collect_list("");
            addPerson(person);
            resultData.setStatus(200);
            resultData.setMessage("注册成功！");
            resultData.setData(person);
        }else{
            resultData.setStatus(400);
            resultData.setMessage("注册失败，用户名重复！");
        }
        return resultData;
    }

    @Override
    public ResultData Login(String user_name, String user_password) {
        ResultData resultData=new ResultData();
        Person person=getPersonByName(user_name);
        if(person==null||!person.getUser_password().equals(user_password))
        {
            resultData.setStatus(400);
            resultData.setMessage("登录失败，用户不存在或密码错误！");
        }else{
            resultData.setStatus(200);
            resultData.setMessage("登录成功！");
        }
        return resultData;
    }
    public ResultData LoginManager(String user_name, String user_password) {
        ResultData resultData=new ResultData();
        Person person=getPersonByName(user_name);
        if(person==null||!person.getUser_password().equals(user_password)||person.getIs_manager()==0)
        {
            resultData.setStatus(400);
            resultData.setMessage("登录失败，用户不存在或密码错误或非管理员用户！");
        }else{
            resultData.setStatus(200);
            resultData.setMessage("登录成功！");
        }
        return resultData;
    }
    @Override
    public ResultData UpdateUserMsg(int user_id,String user_name,String user_password,int user_sex,
                                    int user_age,String user_pro,String user_hobby) {
        ResultData resultData=new ResultData();
        Person person=getPersonById(user_id);
        Person person_temp=getPersonByName(user_name);
        if(person_temp!=null)
        {
            resultData.setStatus(400);
            resultData.setMessage("修改失败，用户名重复！");
        }else{
            person.setUser_name(user_name);
            person.setUser_password(user_password);
            person.setUser_sex(user_sex);
            person.setUser_age(user_age);
            person.setUser_pro(user_pro);
            person.setUser_hobby(user_hobby);
            updatePerson(person);
            resultData.setStatus(200);
            resultData.setMessage("修改成功！");
            resultData.setData(person);
        }
        return resultData;
    }
    public ResultData SearchPerson(String user_name){
        ResultData resultData=new ResultData();
        Person person=getPersonByName(user_name);
        if(person!=null)
        {
            resultData.setStatus(200);
            resultData.setMessage("寻找目标用户存在！");
            resultData.setData(person);
        }else{
            resultData.setStatus(400);
            resultData.setMessage("寻找目标用户不存在！");
        }
        return resultData;
    }

    @Override
    public ResultData ShowFollowList(int user_id) {
        ResultData resultData=new ResultData();
        List<Integer> follow_id_list=personDao.getFollowingList(user_id);
        List<Person> follow_list=new ArrayList<>();
        for(int i:follow_id_list)
        {
            follow_list.add(personDao.getPersonById(i));
        }
        resultData.setStatus(200);
        resultData.setMessage("已返回关注列表用户信息");
        resultData.setData(follow_list);
        return resultData;
    }
    public ResultData ShowFanList(int user_id) {
        ResultData resultData=new ResultData();
        List<Integer> fan_id_list=personDao.getFanList(user_id);
        List<Person> fan_list=new ArrayList<>();
        for(int i:fan_id_list)
        {
            fan_list.add(personDao.getPersonById(i));
        }
        resultData.setStatus(200);
        resultData.setMessage("已返回粉丝列表用户信息");
        resultData.setData(fan_list);
        return resultData;
    }

    @Override
    public ResultData FollowPerson(int user_id, int follow_id) {
        ResultData resultData=new ResultData();
        Person person=getPersonById(user_id);
        if(checkIs_Followed(user_id,follow_id)==1)
        {
            resultData.setStatus(400);
            resultData.setMessage("已关注过该用户！");
        }else{
            Person person2=getPersonById(follow_id);
            if(person.getFollowing_num()==0)
            {
                person.setFollowing_list(person.getFollowing_list()+follow_id);
            }else{
                person.setFollowing_list(person.getFollowing_list()+","+follow_id);
            }
            person.setFollowing_num(person.getFollowing_num()+1);
            if(person2.getFan_num()==0)
            {
                person2.setFan_list(person2.getFan_list()+user_id);
            }else{
                person2.setFan_list(person2.getFan_list()+","+user_id);
            }
            person2.setFan_num(person2.getFan_num()+1);
            personDao.updatePerson(person);
            personDao.updatePerson(person2);
            resultData.setStatus(200);
            resultData.setMessage("成功关注该用户！");
            resultData.setData(person);
        }
        return resultData;
    }
    @Override
    public ResultData CollectTheme(int user_id, int theme_post_id) {
        ResultData resultData=new ResultData();
        Person person=getPersonById(user_id);
        if(checkIs_Collected(user_id,theme_post_id)==1)
        {
            resultData.setStatus(400);
            resultData.setMessage("已收藏过该主题帖！");
        }else{
            String str=person.getTheme_collect_list();
            if(str==null||str.equals(""))
            {
                person.setTheme_collect_list(""+theme_post_id);
            }else{
                person.setTheme_collect_list(str+","+theme_post_id);
            }
            personDao.updatePerson(person);

            resultData.setStatus(200);
            resultData.setMessage("成功收藏该主题帖！");
            resultData.setData(person);
        }
        return resultData;
    }

    @Override
    public ResultData ShowPersonAllByLock() {
        ResultData resultData=new ResultData();
        List<Person> persons=getPersonAllByLock();
        resultData.setStatus(200);
        resultData.setMessage("已返回全部锁定的用户");
        resultData.setData(persons);
        return resultData;
    }

    @Override
    public ResultData UnlockPerson(int user_id) {
        ResultData resultData=new ResultData();
        Person person=getPersonById(user_id);
        person.setUser_lock(0);
        updatePerson(person);

        resultData.setStatus(200);
        resultData.setMessage("已解锁该用户");
        resultData.setData(person);
        return resultData;
    }

    @Override
    public ResultData LockPerson(int user_id) {
        ResultData resultData=new ResultData();
        Person person=getPersonById(user_id);
        person.setUser_lock(1);
        updatePerson(person);

        resultData.setStatus(200);
        resultData.setMessage("已锁定该用户");
        resultData.setData(person);
        return resultData;
    }
}
