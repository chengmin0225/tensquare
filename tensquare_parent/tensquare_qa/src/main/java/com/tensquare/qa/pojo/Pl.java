package com.tensquare.qa.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *中间表
 * @author 程民
 * @date 2018/10/17
 */
@Entity
@Table(name = "tb_pl")
public class Pl implements Serializable {
    private static final long serialVersionUID = -5649514653928913134L;

    @Id
    private String problemid;

    @Id
    private String labelid;

}
