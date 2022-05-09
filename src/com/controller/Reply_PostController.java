package com.controller;

import com.Result.ResultData;
import com.service.Reply_PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class Reply_PostController {
    @Autowired
    Reply_PostService reply_postService;

    @RequestMapping("replyMsg.do")
    @ResponseBody
    public ResultData replyMsg(@RequestParam(name="reply_post_id",required = true)int reply_post_id)
    {
        ResultData resultData=reply_postService.ReplyMsg(reply_post_id);
        return resultData;
    }
    @RequestMapping("showReplyAllByUser_id.do")
    @ResponseBody
    public ResultData showReplyAllByUser_id(@RequestParam(name="user_id",required = true) int user_id)
    {
        ResultData resultData=reply_postService.ShowReplyAllByUser_id(user_id);
        return resultData;
    }
    @RequestMapping("showReplyAllByTheme.do")
    @ResponseBody
    public ResultData showReplyAllByTheme(@RequestParam(name="theme_post_id",required = true) int theme_post_id)
    {
        ResultData resultData=reply_postService.ShowReplyAllByTheme(theme_post_id);
        return resultData;
    }
    @RequestMapping("addNewReply.do")
    @ResponseBody
    public ResultData addNewReply(@RequestParam(name="theme_post_id",required = true) int theme_post_id,
                                  @RequestParam(name="user_id",required = true) int user_id,
                                  @RequestParam(name="reply_post_content",required = true) String reply_post_content)
    {
        ResultData resultData=reply_postService.AddNewReply(theme_post_id,user_id,reply_post_content);
        return resultData;
    }
    @RequestMapping("lockReply.do")
    @ResponseBody
    public ResultData lockReply(@RequestParam(name="reply_post_id",required = true)int reply_post_id)
    {
        ResultData resultData=reply_postService.LockReply(reply_post_id);
        return resultData;
    }
}
