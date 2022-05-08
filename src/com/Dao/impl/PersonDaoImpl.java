package com.Dao.impl;

import com.Dao.PersonDao;
import com.entity.Person;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {
    @Resource
    private JdbcTemplate jdbcTemplate;
    /*
    @Resource
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
*/
    @Override
    public int addPerson(Person person) {
        String sql=
                "INSERT INTO person(user_id,user_name,user_password,user_sex,user_age," +
                        "user_pro,user_hobby,following_list,fan_list,following_num,fan_num,user_lock," +
                        "theme_collect_list,is_manager) " +
                        "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int update=jdbcTemplate.update(sql, person.getUser_id(),person.getUser_name(),
                person.getUser_password(),person.getUser_sex(),person.getUser_age(),
                person.getUser_pro(), person.getUser_hobby(), person.getFollowing_list(),
                person.getFan_list(), person.getFollowing_num(), person.getFan_num(),
                person.getUser_lock(),person.getTheme_collect_list(),person.getIs_manager());
        return update;
    }

    @Override
    public int updatePerson(Person person) {
        String sql=
                "UPDATE person SET user_name=?,user_password=?,user_sex=?,user_age=?," +
                        "user_pro=?,user_hobby=?,following_list=?,fan_list=?,following_num=?," +
                        "fan_num=?,user_lock=?,theme_collect_list=?,is_manager=? " +
                        "WHERE user_id=?";
        int update=jdbcTemplate.update(sql,person.getUser_name(),
                person.getUser_password(),person.getUser_sex(),person.getUser_age(),
                person.getUser_pro(), person.getUser_hobby(), person.getFollowing_list(),
                person.getFan_list(), person.getFollowing_num(), person.getFan_num(),
                person.getUser_lock(),person.getTheme_collect_list(),person.getIs_manager(),
                person.getUser_id());
        return update;
    }

    public Person getPersonById(int user_id){
        String sql="SELECT * FROM person WHERE user_id=?";
        try{
            return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Person.class),user_id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }

    }
    public Person getPersonByName(String user_name){
        String sql="SELECT * FROM person WHERE user_name=?";
        try{
            return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Person.class),user_name);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Person> getPersonAllByLock() {
        String sql="SELECT * FROM person WHERE user_lock=1";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Person.class));
    }

    public int countPersonNum(){
        String sql = "SELECT COUNT(*) FROM person";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public int deletePerson(Person person) {
        String sql="DELETE FROM person WHERE user_id=?";
        return jdbcTemplate.update(sql,person.getUser_id());
    }

    @Override
    public List<Integer> getFollowingList(int user_id) {
        String sql="SELECT following_list FROM person WHERE user_id="+user_id;
        String following_list=new String();
        try{
            following_list= jdbcTemplate.queryForObject(sql,String.class);
            if(following_list==null||following_list.equals(""))
                return null;
            String[] split=following_list.split(",");
            List<Integer> follow=new ArrayList<>();
            for(String i:split)
            {
                follow.add(Integer.valueOf(i));
            }
            return follow;
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Integer> getFanList(int user_id) {
        String sql="SELECT fan_list FROM person WHERE user_id="+user_id;
        String fan_list=new String();
        try{
            fan_list= jdbcTemplate.queryForObject(sql,String.class);
            if(fan_list==null||fan_list.equals(""))
                return null;
            String[] split=fan_list.split(",");
            List<Integer> fan=new ArrayList<>();
            for(String i:split)
            {
                fan.add(Integer.valueOf(i));
            }
            return fan;
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Integer> getThemeCollectList(int user_id) {
        String sql="SELECT theme_collect_list FROM person WHERE user_id="+user_id;
        String theme_collect_list=new String();
        try{
            theme_collect_list= jdbcTemplate.queryForObject(sql,String.class);
            if(theme_collect_list==null||theme_collect_list.equals(""))
                return null;
            String[] split=theme_collect_list.split(",");
            List<Integer> theme_collect=new ArrayList<>();
            for(String i:split)
            {
                theme_collect.add(Integer.valueOf(i));
            }
            return theme_collect;
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
