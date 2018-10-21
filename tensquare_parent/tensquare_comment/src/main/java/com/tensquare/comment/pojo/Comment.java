package com.tensquare.comment.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 程民
 * @date 2018/10/21
 */
@Data
public class Comment implements Serializable {

    private static final long serialVersionUID = -4827479176207465314L;

    @Id
    private String id;
    private String articleid;
    private String content;
    private String userid;
    private String parentid;
    private Date publishdate;
}
