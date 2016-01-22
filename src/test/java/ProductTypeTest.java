import com.cloudteddy.gemcs01test.configuration.AppConfigure;
import com.cloudteddy.gemcs01test.model.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.List;
import java.util.Set;

/**
 * Created by kimtung on 1/22/16.
 */
public class ProductTypeTest {

    private AbstractApplicationContext context;
    private SessionFactory sessionFactory;
    private Session session;

    @Before
    public void before() {
        context = new AnnotationConfigApplicationContext(AppConfigure.class);
        sessionFactory = (SessionFactory) context.getBean("sessionFactory");
        session = sessionFactory.openSession();
    }

    @Test
    public void testSaveAndRetrive() {
        Product.Type type = new Product.Type();
        type.setName("unit");
        session.save(type);

        Criteria criteria = session.createCriteria(Product.Type.class);
        List<Product.Type> types = criteria.list();

        //is saving successful?
        Assert.assertNotNull(types);
        Assert.assertEquals(1, types.size());

        //is the saved type match original one?
        Product.Type retrievedType = types.get(0);
        Assert.assertEquals(type, retrievedType);
    }

}
