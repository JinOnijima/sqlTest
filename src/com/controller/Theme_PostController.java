package com.controller;

import com.Result.ResultData;
import com.entity.Theme_Post;
import com.service.Theme_PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Theme_PostController {
    @Autowired
    Theme_PostService theme_postService;

    @RequestMapping("showThemeAll.do")
    @ResponseBody
    public ResultData showThemeAll()
    {
        ResultData resultData=theme_postService.ShowThemeAll();
        return resultData;
    }
    @RequestMapping("showThemeAllByLock.do")
    @ResponseBody
    public ResultData showThemeAllByLock()
    {
        ResultData resultData=theme_postService.ShowThemeAllByLock();
        return resultData;
    }
    @RequestMapping("showThemeCollected.do")
    @ResponseBody
    public ResultData showThemeCollected(@RequestParam(name="user_id",required = true) int user_id)
    {
        ResultData resultData=theme_postService.ShowThemeCollected(user_id);
        return resultData;
    }
    @RequestMapping("addNewTheme.do")
    @ResponseBody
    public ResultData AddNewTheme(@RequestParam(name="theme_post_title",required = true) String theme_post_title,
                                  @RequestParam(name="theme_post_content",required = true) String theme_post_content,
                                  @RequestParam(name="user_id",required = true) int user_id)
    {
        ResultData resultData=theme_postService.AddNewTheme(theme_post_title,theme_post_content,
                user_id);
        return resultData;
    }
    @RequestMapping("unlockTheme.do")
    @ResponseBody
    public ResultData unlockTheme(@RequestParam(name="theme_post_id",required = true) int theme_post_id)
    {
        ResultData resultData=theme_postService.UnlockTheme(theme_post_id);
        return resultData;
    }
    @RequestMapping("lockTheme.do")
    @ResponseBody
    public ResultData lockTheme(@RequestParam(name="theme_post_id",required = true) int theme_post_id)
    {
        ResultData resultData=theme_postService.LockTheme(theme_post_id);
        return resultData;
    }
    @RequestMapping("setFineTheme.do")
    @ResponseBody
    public ResultData setFineTheme(@RequestParam(name="theme_post_id",required = true) int theme_post_id)
    {
        ResultData resultData=theme_postService.SetFineTheme(theme_post_id);
        return resultData;
    }
    @RequestMapping("cancelFineTheme.do")
    @ResponseBody
    public ResultData cancelFineTheme(@RequestParam(name="theme_post_id",required = true) int theme_post_id)
    {
        ResultData resultData=theme_postService.CancelFineTheme(theme_post_id);
        return resultData;
    }
    @RequestMapping("setTopTheme.do")
    @ResponseBody
    public ResultData setTopTheme(@RequestParam(name="theme_post_id",required = true) int theme_post_id)
    {
        ResultData resultData=theme_postService.SetTopTheme(theme_post_id);
        return resultData;
    }
    @RequestMapping("cancelTopTheme.do")
    @ResponseBody
    public ResultData cancelTopTheme(@RequestParam(name="theme_post_id",required = true) int theme_post_id)
    {
        ResultData resultData=theme_postService.CancelTopTheme(theme_post_id);
        return resultData;
    }
}
