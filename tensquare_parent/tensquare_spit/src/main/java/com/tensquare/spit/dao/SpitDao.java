package com.tensquare.spit.dao;

import com.tensquare.spit.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author gg
 * @date 2018/10/20
 */
public interface SpitDao extends MongoRepository<Spit,String> {

    /**
     * 根据上级id,查询吐槽列表分页
     * @param parentid
     * @param pageable
     * @return
     */
    Page<Spit> findByParentid(String parentid, Pageable pageable);


}
