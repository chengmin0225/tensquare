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
@Table(name="tb_reply")
@Data
public class Reply implements Serializable{

	private static final long serialVersionUID = -6904527443656717979L;
	/**
	 *编号
	 */
	@Id
	private String id;
	/**
	 *问题ID
	 */
	private String problemid;
	/**
	 *回答内容
	 */
	private String content;
	/**
	 *创建日期
	 */
	private java.util.Date createtime;
	/**
	 *更新日期
	 */
	private java.util.Date updatetime;
	/**
	 *回答人ID
	 */
	private String userid;
	/**
	 *回答人昵称
	 */
	private String nickname;

}
