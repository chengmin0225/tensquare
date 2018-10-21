package com.tensquare.spit.service;

import com.tensquare.spit.dao.SpitDao;
import com.tensquare.spit.pojo.Spit;
import com.tensquare.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *
 * @author gg
 * @date 2018/10/20
 */
@Service
public class SpitService {

    @Autowired
    private SpitDao spitDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查询全部记录
     * @return
     */
    public List<Spit> findAll(){
        return spitDao.findAll();
    }

    /**
     * 根据主键查询实体
     * @param id
     * @return
     */
    public Spit findById(String id){
        Spit spit = spitDao.findById(id).get();
        return spit;
    }

    /**
     * 增加
     * @param spit
     */
    public void add(Spit spit){
        spit.setId(idWorker.nextId()+"");
        spit.setPublishtime(new Date());
        //当前用户的id
        spit.setUserid("1");
        //当前用于的昵称
        spit.setNickname("");
        //浏览数
        spit.setVisits(0);
        //分享数
        spit.setShare(0);
        //点赞数
        spit.setThumbup(0);
        //回复数
        spit.setComment(0);
        //状态
        spit.setState("1");
        //如果存在上级吐糟id
        if(spit.getParentid() != null || "".equals(spit.getParentid())){
            //获取上一级吐槽
            Spit lastSpit = spitDao.findById(spit.getParentid()).get();
            //将评论数加1
            lastSpit.setComment(lastSpit.getComment() + 1);
            spitDao.save(lastSpit);
        }
        spitDao.save(spit);
    }

    /**
     * 修改
     * @param spit
     */
    public void update(Spit spit){
        spitDao.save(spit);
    }

    /**
     * 删除
     * @param id
     */
    public void delete(String id){
        spitDao.deleteById(id);
    }

    /**
     *根据上级id,查询吐槽列表分页
     * @param parentid
     * @param page
     * @param size
     * @return
     */
    public Page<Spit> findByParentid(String parentid,int page,int size){
        PageRequest pageRequest = PageRequest.of(page - 1,size);
        return spitDao.findByParentid(parentid,pageRequest);
    }

    /**
     * 点赞
     * @param id
     */
    public void updateThumbup(String id){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Update update = new Update();
        update.inc("thumbup",1);
        mongoTemplate.updateFirst(query,update,"spit");
    }

    /**
     * 浏览数
     * @param id
     */
    public void updateVisits(String id){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Update update = new Update();
        update.inc("visits",1);
        mongoTemplate.updateFirst(query,update,"visits");
    }

    /**
     * 分享数
     * @param id
     */
    public void updateShare(String id){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Update update = new Update();
        update.inc("share",1);
        mongoTemplate.updateFirst(query,update,"share");
    }

}
