package com.tensquare.entity;

import java.util.List;

/**
 * @author 程民
 */
public class PageResult<T> {

    private Long page;
    private List<T> rows;


    public PageResult(Long page, List<T> rows) {
        this.page = page;
        this.rows = rows;
    }


    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
