package com.tensquare.comment.dao;

import com.tensquare.comment.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 *
 * @author 程民
 * @date 2018/10/21
 */
public interface CommentDao extends MongoRepository<Comment,String> {

    /**
     * 根据文章id查找评论列表
     * @param articleid
     * @return
     */
    List<Comment> findByArticleid(String articleid);
}
