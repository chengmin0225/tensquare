package com.tensquare.qa.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_problem")
@Data
public class Problem implements Serializable{

	private static final long serialVersionUID = 8592768933755213999L;
	/**
	 *ID
	 */
	@Id
	private String id;
	/**
	 *标题
	 */
	private String title;
	/**
	 *内容
	 */
	private String content;
	/**
	 *
	 */
	private java.util.Date createtime;
	/**
	 *
	 */
	private java.util.Date updatetime;
	/**
	 *
	 */
	private String userid;
	/**
	 *
	 */
	private String nickname;
	/**
	 *
	 */
	private Long visits;
	/**
	 *点赞数
	 */
	private Long thumbup;
	/**
	 *回复数
	 */
	private Long reply;
	/**
	 *是否解决
	 */
	private String solve;
	/**
	 *回复人昵称
	 */
	private String replyname;
	/**
	 *回复日期
	 */
	private java.util.Date replytime;

}
