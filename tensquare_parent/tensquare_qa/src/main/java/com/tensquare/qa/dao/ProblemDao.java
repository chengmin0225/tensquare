package com.tensquare.qa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author 程民
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{

    /**
     * 根据标签Id查询最新问题列表
     * @param labelId
     * @param pageable
     * @return
     */
    @Query("select p from Problem p where id in (select problemid from Pl where labelid = ?1) order by replytime desc")
    Page<Problem> findNewListByLabelId(String labelId, Pageable pageable);

    /**
     * 根据标签id查询热门问题
     * @param labelId
     * @param pageable
     * @return
     */
    @Query("select p from Problem p where id in (select problemid from Pl where labelid = ?1) order by reply desc")
    Page<Problem> findHotListByLabelId(String labelId, Pageable pageable);

    /**
     * 根据标签id查询等待回答列表
     * @param labelId
     * @param pageable
     * @return
     */
    @Query("select p from Problem p where id in (select problemid from Pl where labelid = ?1) and reply=0 order by createtime desc")
    Page<Problem> findWaitListByLabelId(String labelId, Pageable pageable);
}

