package com.tensquare.comment.service;

import com.tensquare.comment.dao.CommentDao;
import com.tensquare.comment.pojo.Comment;
import com.tensquare.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author 程民
 * @date 2018/10/21
 */
@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 添加评论
     *
     * @param comment
     */
    public void add(Comment comment) {
        comment.setId(String.valueOf(idWorker.nextId()));
        commentDao.save(comment);
    }

    /**
     *根据文章id查找评论列表
     * @param articleid
     * @return
     */
    public List<Comment> findByArticleid(String articleid) {
        return commentDao.findByArticleid(articleid);
    }
}
