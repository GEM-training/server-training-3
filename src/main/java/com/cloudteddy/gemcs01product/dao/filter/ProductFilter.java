package com.cloudteddy.gemcs01product.dao.filter;

import com.cloudteddy.gemcs01product.dao.model.Product;

/**
 * Created by kimtung on 28/01/16.
 */
public class ProductFilter {

    private Product.Type type;
    private String keyword;
    private int pageSize = 25;
    private int page = 0;

    public Product.Type getType() {
        return type;
    }

    public ProductFilter setType(Product.Type type) {
        this.type = type;
        return this;
    }

    public String getKeyword() {
        return keyword;
    }

    public ProductFilter setKeyword(String keyword) {
        this.keyword = keyword;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public ProductFilter setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public int getPage() {
        return page;
    }

    public ProductFilter setPage(int page) {
        this.page = page;
        return this;
    }
}
