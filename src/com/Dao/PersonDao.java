package com.Dao;

import com.entity.Person;

import java.util.List;

public interface PersonDao {
    int addPerson(Person person);
    int updatePerson(Person person);
    Person getPersonById(int user_id);
    Person getPersonByName(String user_name);
    List<Person> getPersonAllByLock();
    int countPersonNum();
    int deletePerson(Person person);
    List<Integer> getFollowingList(int user_id);
    List<Integer> getFanList(int user_id);
    List<Integer> getThemeCollectList(int user_id);
}
