package com.tensquare.base.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 程民
 */
@Entity
@Table(name = "tb_label")
@Data
public class Label implements Serializable{

    private static final long serialVersionUID = -487055543185370419L;

    @Id
    private String id;

    /**
     * 标签名称
     */
    private String labelName;

    /**
     * 状态
     */
    private String state;

    /**
     * 使用数量
     */
    private Long count;

    /**
     * 关注数
     */
    private Long fans;

    /**
     *是否推荐
     */
    private String recommend;
}
