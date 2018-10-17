package com.tensquare.base.service;


import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import com.tensquare.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 程民
 */
@Service
public class LabelService {

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询所有的标签
     */
    public List<Label> findAll() {
        return labelDao.findAll();
    }

    /**
     * 根据id查询标签
     */
    public Label findById(String id) {
        return labelDao.findById(id).get();
    }

    /**
     * 保存
     */
    public void save(Label label) {
        label.setId(String.valueOf(idWorker.nextId()));
        labelDao.save(label);
    }

    /**
     * 更新
     */
    public void update(Label label) {
        labelDao.save(label);
    }

    /**
     * 删除
     */
    public void delete(String id) {
        Label label = labelDao.findById(id).get();
        labelDao.delete(label);
    }

    /**
     * 条件查询
     *
     * @param searchMap
     * @return
     */
    public List<Label> findSearch(Map searchMap) {
        Specification<Label> specification = createSpecification(searchMap);
        return labelDao.findAll(specification);
    }

    /**
     * @param searchMap
     * @return
     */
    private Specification<Label> createSpecification(Map searchMap) {
        return (root, criteriaQuery, cb) -> {
            List<Predicate> predicateList = new ArrayList<>();
            if (searchMap.get("labelName") != null &&
                    !"".equals(searchMap.get("labelName"))) {
                predicateList.add(cb.like(
                        root.get("labelName").as(String.class), "%" +
                                (String) searchMap.get("labelName") + "%"));
            }
            if (searchMap.get("state") != null &&
                    !"".equals(searchMap.get("state"))) {
                predicateList.add(cb.equal(
                        root.get("state").as(String.class), (String) searchMap.get("state")));
            }
            if (searchMap.get("recommend") != null &&
                    !"".equals(searchMap.get("recommend"))) {
                predicateList.add(cb.equal(
                        root.get("recommend").as(String.class),
                        (String) searchMap.get("recommend")));
            }
            return cb.and(predicateList.toArray(new
                    Predicate[predicateList.size()]));
        };
    }

    /**
     * 带分页的查询
     */
    public Page<Label> findSearch(Map searchMap, int page, int size){
        Specification<Label> specification = createSpecification(searchMap);
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return labelDao.findAll(specification,pageRequest);
    }
}
