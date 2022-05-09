package com.service;

import com.Result.ResultData;
import com.entity.Person;

import java.util.List;

public interface PersonService {
    int addPerson(Person person);
    int updatePerson(Person person);
    Person getPersonById(int user_id);
    Person getPersonByName(String user_name);
    List<Person> getPersonAllByLock();
    int countPersonNum();
    int deletePerson(Person person);
    int checkIs_Followed(int user_id,int follow_id);
    int checkIs_Collected(int user_id,int theme_post_id);

    ResultData Register(String user_name,String user_password,int user_sex,int user_age,
                        String user_pro,String user_hobby);
    ResultData Login(String user_name,String user_password);
    ResultData LoginManager(String user_name,String password);
    ResultData UpdateUserMsg(int user_id,String user_name,String user_password,int user_sex,
                             int user_age,String user_pro,String user_hobby);
    ResultData PersonMsg(int user_id);
    ResultData SearchPerson(String user_name);
    ResultData ShowFollowList(int user_id);
    ResultData ShowFanList(int user_id);
    ResultData FollowPerson(int user_id,int follow_id);
    ResultData CollectTheme(int user_id,int theme_post_id);
    ResultData ShowPersonAllByLock();
    ResultData UnlockPerson(int user_id);
    ResultData LockPerson(int user_id);
}
