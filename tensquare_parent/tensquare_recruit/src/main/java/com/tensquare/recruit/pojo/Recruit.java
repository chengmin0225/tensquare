package com.tensquare.recruit.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_recruit")
@Data
public class Recruit implements Serializable{

	private static final long serialVersionUID = 3883155709392657007L;

	@Id
	private String id;
	private String jobname;
	private String salary;
	private String conditions;
	private String education;
	private String type;
	private String address;
	private String eid;
	private Date createtime;
	private String state;
	private String url;
	private String label;
	private String content1;
	private String content2;

}
