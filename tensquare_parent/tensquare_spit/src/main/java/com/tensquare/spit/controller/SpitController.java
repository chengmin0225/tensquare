package com.tensquare.spit.controller;

import com.tensquare.entity.PageResult;
import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import com.tensquare.spit.pojo.Spit;
import com.tensquare.spit.service.SpitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author 程民
 * @date 2018/10/21
 */
@RestController
@CrossOrigin
@RequestMapping("/spit")
public class SpitController {

    @Autowired
    private SpitService spitService;

    /**
     * 获取全部记录
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查找成功", spitService.findAll());
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "查找成功", spitService.findById(id));
    }

    /**
     * 增加
     *
     * @param spit
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Spit spit) {
        spitService.add(spit);
        return new Result(true, StatusCode.OK, "增加成功");
    }

    /**
     * 更新
     * @param id
     * @param spit
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@PathVariable String id,@RequestBody Spit spit) {
        spit.setId(id);
        spitService.update(spit);
        return new Result(true, StatusCode.OK, "更新成功");
    }

    /**
     * 删除成功
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id){
        spitService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /**
     *根据上级id,查询吐槽列表分页
     * @param parentid
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/comment/{parentid}/{page}/{size}", method = RequestMethod.GET)
    public Result findByParentid(@PathVariable String parentid,@PathVariable int page,@PathVariable int size){
        Page<Spit> pageList = spitService.findByParentid(parentid, page, size);
        PageResult<Spit> spitPageResult = new PageResult<>(pageList.getTotalElements(), pageList.getContent());
        return new Result(true, StatusCode.OK, "查询成功",spitPageResult);
    }

    /**
     * 浏览数
     * @param id
     * @return
     */
    @RequestMapping(value = "/visits/{id}", method = RequestMethod.PUT)
    public Result updateVisits(@PathVariable String id){
        spitService.updateVisits(id);
        return new Result(true, StatusCode.OK, "浏览成功");
    }

    /**
     * 分享数
     * @param id
     * @return
     */
    @RequestMapping(value = "/share/{id}", method = RequestMethod.PUT)
    public Result updateShare(@PathVariable String id){
        spitService.updateShare(id);
        return new Result(true, StatusCode.OK, "分享成功");
    }

    /**
     * 点赞
     * @param id
     * @return
     */
    @RequestMapping(value = "/thumbup/{id}", method = RequestMethod.PUT)
    public Result updateThumbup(@PathVariable String id){
        spitService.updateThumbup(id);
        return new Result(true, StatusCode.OK, "点赞成功");
    }
}
