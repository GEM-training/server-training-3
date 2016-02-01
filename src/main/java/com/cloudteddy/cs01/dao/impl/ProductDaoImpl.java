package com.cloudteddy.cs01.dao.impl;

import com.cloudteddy.cs01.dao.ProductDao;
import com.cloudteddy.cs01.dao.filter.ProductFilter;
import com.cloudteddy.cs01.model.Product;
import org.apache.lucene.search.Query;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kimtung on 01/02/16.
 */
@Repository("dao_product")
public class ProductDaoImpl extends AbstractDao<Product> implements ProductDao {

    public ProductDaoImpl() {
        super(Product.class);
    }

    public List<Product> list(ProductFilter filter) {
        if(filter.keyword != null) {
            FullTextSession fullTextSession = Search.getFullTextSession(getSession());
            QueryBuilder queryBuilder = fullTextSession.getSearchFactory()
                    .buildQueryBuilder().forEntity(Product.class).get();
            Query luceneQuery = queryBuilder.keyword()
                    .onFields("name_ngram", "detail_ngram")
                    .matching(filter.keyword.toLowerCase()).createQuery();
            org.hibernate.Query hibernateQuery = fullTextSession.createFullTextQuery(luceneQuery, Product.class);
            hibernateQuery.setFirstResult(filter.page * filter.pageSize);
            hibernateQuery.setMaxResults(filter.pageSize);
            return hibernateQuery.list();
        } else {
            Criteria criteria = getSession().createCriteria(Product.class);
            criteria.addOrder(Order.asc("name"));
            criteria.setFirstResult(filter.page * filter.pageSize);
            criteria.setMaxResults(filter.pageSize);
            return criteria.list();
        }
    }


}
