package com.cloudteddy.gemcs01product.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.search.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Created by kimtung on 29/01/16.
 */
@Component
public class ContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            Search.getFullTextSession(sessionFactory.openSession())
                    .createIndexer().startAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("refreshed");
    }
}
