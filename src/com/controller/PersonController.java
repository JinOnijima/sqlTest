package com.controller;

import com.Result.ResultData;
import com.entity.Person;
import com.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping("/register.do")
    @ResponseBody
    public ResultData register(@RequestParam(name="user_name",required=true) String user_name,
                               @RequestParam(name="user_password",required=true) String user_password,
                               @RequestParam(name="user_sex",required=true) int user_sex,
                               @RequestParam(name="user_age",required=true) int user_age,
                               @RequestParam(name="user_pro",required=true) String user_pro,
                               @RequestParam(name="user_hobby",required=true) String user_hobby) {
        ResultData resultData = personService.Register(user_name,user_password,user_sex,
                user_age,user_pro,user_hobby);
        return resultData;
    }
    @RequestMapping("/login.do")
    @ResponseBody
    public ResultData login(@RequestParam(name="user_name",required=true) String user_name,
                               @RequestParam(name="user_password",required=true) String user_password) {
        ResultData resultData = personService.Login(user_name,user_password);
        return resultData;
    }
    @RequestMapping("/loginManager.do")
    @ResponseBody
    public ResultData loginManager(@RequestParam(name="user_name",required=true) String user_name,
                            @RequestParam(name="user_password",required=true) String user_password) {
        ResultData resultData = personService.LoginManager(user_name,user_password);
        return resultData;
    }
    @RequestMapping("/updateUserMsg.do")
    @ResponseBody
    public ResultData updateUserMsg(@RequestParam(name="user_id",required=true) int user_id,
                                    @RequestParam(name="user_name",required=true) String user_name,
                                    @RequestParam(name="user_password",required=true) String user_password,
                                    @RequestParam(name="user_sex",required=true) int user_sex,
                                    @RequestParam(name="user_age",required=true) int user_age,
                                    @RequestParam(name="user_pro",required=true) String user_pro,
                                    @RequestParam(name="user_hobby",required=true) String user_hobby)
    {
        ResultData resultData=personService.UpdateUserMsg(user_id,user_name,user_password,
                user_sex,user_age,user_pro,user_hobby);
        return resultData;
    }
    @RequestMapping("/searchPerson.do")
    @ResponseBody
    public ResultData searchPerson(@RequestParam(name="user_name",required = true) String user_name)
    {
        ResultData resultData=personService.SearchPerson(user_name);
        return resultData;
    }
    @RequestMapping("/showFollowList.do")
    @ResponseBody
    public ResultData showFollowList(@RequestParam(name="user_id",required = true) int user_id)
    {
        ResultData resultData=personService.ShowFollowList(user_id);
        return resultData;
    }
    @RequestMapping("/showFanList.do")
    @ResponseBody
    public ResultData showFanList(@RequestParam(name="user_id",required = true) int user_id)
    {
        ResultData resultData=personService.ShowFanList(user_id);
        return resultData;
    }
    @RequestMapping("/followPerson.do")
    @ResponseBody
    public ResultData followPerson(@RequestParam(name="user_id",required = true) int user_id,
                                   @RequestParam(name="follow_id",required = true) int follow_id)
    {
        ResultData resultData=personService.FollowPerson(user_id,follow_id);
        return resultData;
    }
    @RequestMapping("/collectTheme.do")
    @ResponseBody
    public ResultData collectTheme(@RequestParam(name="user_id",required = true) int user_id,
                                   @RequestParam(name="theme_post_id",required = true) int theme_post_id)
    {
        ResultData resultData=personService.CollectTheme(user_id,theme_post_id);
        return resultData;
    }
    @RequestMapping("/showPersonAllByLock.do")
    @ResponseBody
    public ResultData showPersonAllByLock()
    {
        ResultData resultData=personService.ShowPersonAllByLock();
        return resultData;
    }
    @RequestMapping("/unlockPerson.do")
    @ResponseBody
    public ResultData unlockPerson(@RequestParam(name="user_id",required = true) int user_id)
    {
        ResultData resultData=personService.UnlockPerson(user_id);
        return resultData;
    }
    @RequestMapping("/lockPerson.do")
    @ResponseBody
    public ResultData lockPerson(@RequestParam(name="user_id",required = true) int user_id)
    {
        ResultData resultData=personService.LockPerson(user_id);
        return resultData;
    }
}
