package com.cloudteddy.gemcs01product.dao;

/**
 * Created by kimtung on 28/01/16.
 */
public class Pagination {

    private int pageSize;
    private int pageNum;

    public Pagination(int pageSize, int pageNum) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }

    public Pagination() {
    }

    public int getPageNum() {
        return pageNum;
    }

    public Pagination setPageNum(int pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public Pagination setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }
}
