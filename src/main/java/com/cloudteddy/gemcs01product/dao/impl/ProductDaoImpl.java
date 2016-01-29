package com.cloudteddy.gemcs01product.dao.impl;

import com.cloudteddy.gemcs01product.dao.ProductDao;
import com.cloudteddy.gemcs01product.dao.filter.ProductFilter;
import com.cloudteddy.gemcs01product.dao.model.Product;
import org.apache.lucene.search.Query;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kimtung on 1/27/16.
 */
@Repository("dao_product")
@Transactional()
public class ProductDaoImpl extends AbstractDao implements ProductDao {

    @Override
    public List<Product> list() {
        Criteria criteria = getSession().createCriteria(Product.class);
        criteria.addOrder(Order.asc("name"));
        return criteria.list();
    }

    @Override
    public List<Product> list(ProductFilter filter) {
        if(filter.getKeyword() != null) {
            FullTextSession fullTextSession = Search.getFullTextSession(getSession());
            QueryBuilder queryBuilder = fullTextSession.getSearchFactory()
                    .buildQueryBuilder().forEntity(Product.class).get();
            Query luceneQuery = queryBuilder.keyword()
                    .onFields("name_ngram", "detail_ngram")
                    .matching(filter.getKeyword().toLowerCase()).createQuery();
            org.hibernate.Query hibernateQuery = fullTextSession.createFullTextQuery(luceneQuery, Product.class);
            hibernateQuery.setFirstResult(filter.getPage() * filter.getPageSize());
            hibernateQuery.setMaxResults(filter.getPageSize());
            return hibernateQuery.list();
        } else {
            Criteria criteria = getSession().createCriteria(Product.class);
            criteria.addOrder(Order.asc("name"));
            criteria.setFirstResult(filter.getPage() * filter.getPageSize());
            criteria.setMaxResults(filter.getPageSize());
            return criteria.list();
        }
    }

    @Override
    public Long count() {
        Criteria criteria = getSession().createCriteria(Product.class);
        criteria.setProjection(Projections.rowCount());
        return (Long) criteria.uniqueResult();
    }

    @Override
    public Product getById(long id) {
        Criteria criteria = getSession().createCriteria(Product.class);
        criteria.add(Restrictions.eq("id", id));
        return (Product) criteria.uniqueResult();
    }

    @Override
    public void update(Product product) {
        System.out.print(product.getType());
        getSession().update(product);
    }

    @Override
    public void insert(Product product) {
        getSession().save(product);
    }

    @Override
    public void delete(Product product) {
        getSession().delete(product);
    }
}
