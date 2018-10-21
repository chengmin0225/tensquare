package com.tensquare.comment.controller;

import com.tensquare.comment.pojo.Comment;
import com.tensquare.comment.service.CommentService;
import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author gg
 * @date 2018/10/21
 */
@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 评论
     * @param comment
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Comment comment) {
        commentService.add(comment);
        return new Result(true, StatusCode.OK,"保存成功");
    }

    /**
     * 根据文章id查找评论列表
     * @param articleid
     * @return
     */
    @RequestMapping(value = "/article/{articleid}",method = RequestMethod.GET)
    public Result findByArticleid(@PathVariable String articleid) {
        return new Result(true, StatusCode.OK,"保存成功",commentService.findByArticleid(articleid));
    }

}
