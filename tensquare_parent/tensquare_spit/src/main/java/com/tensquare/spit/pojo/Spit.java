package com.tensquare.spit.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author gg
 * @date 2018/10/20
 */
@Data
public class Spit implements Serializable {

    private static final long serialVersionUID = 1684259018621922238L;
    private String id;
    private String content;
    private Date publishtime;
    private String userid;
    private String nickname;
    private Integer visits;
    private Integer thumbup;
    private Integer share;
    private Integer comment;
    private String state;
    private String parentid;

}
