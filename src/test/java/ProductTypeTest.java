import com.cloudteddy.gemcs01test.configuration.AppConfigure;
import com.cloudteddy.gemcs01test.model.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.List;

/**
 * Created by kimtung on 1/22/16.
 */
public class ProductTypeTest {

    private static AbstractApplicationContext context;
    private static SessionFactory sessionFactory;
    private static Session session;

    @BeforeClass
    public static void before() {
        context = new AnnotationConfigApplicationContext(AppConfigure.class);
        sessionFactory = (SessionFactory) context.getBean("sessionFactory");

    }

//    @AfterClass
//    public static void after() {
//        context = null;
//        sessionFactory.close();
//        session.close();
//    }

    @Test
    public void testCreateAndRead() {
        Transaction transaction = session.beginTransaction();
        Product.Type unit = new Product.Type();
        session.persist(unit);
        unit.setName("testInsert1");
        System.out.println(unit);
        Product.Type part = new Product.Type();
        session.persist(part);
        part.setName("testInsert2");
        System.out.println(part);
        transaction.commit();

        Criteria criteria = session.createCriteria(Product.Type.class);
        criteria.addOrder(Order.asc("id"));
        List<Product.Type> types = criteria.list();

        Assert.assertNotNull(types);
        Assert.assertEquals(2, types.size());

        Assert.assertEquals(unit, types.get(0));
        Assert.assertEquals(part, types.get(1));

        System.out.println(types.get(0));
        System.out.println(types.get(1));
    }

    @Test
    public void testDelete() {
        Product.Type mockType = new Product.Type();
        mockType.setName("testDelete");
        session.persist(mockType);
        session.flush();

        Object unit = session.load(Product.Type.class, mockType.getId());
        System.out.println(mockType.getId());
        if(unit != null) {
            session.delete(unit);
        }
        session.flush();

        Criteria criteria = session.createCriteria(Product.Type.class);
        criteria.add(Restrictions.eq("id", mockType.getId()));
        Product.Type retrievedUnit = (Product.Type) criteria.uniqueResult();
        Assert.assertNull(retrievedUnit);
    }

    @Test
    public void testUpdate() {
        Product.Type mockType = new Product.Type();
        mockType.setName("testUpdateFailed");
        session.persist(mockType);
        session.flush();

        Object loadedType = session.load(Product.Type.class, mockType.getId());
        if(loadedType != null) {
            Assert.assertEquals(loadedType, mockType);
            ((Product.Type) loadedType).setName("testUpdateSucceeded");
            mockType.setName("testUpdateSucceeded");
            session.update(loadedType);
        }
        session.flush();

        loadedType = session.load(Product.Type.class, mockType.getId());
        if(loadedType != null) {
            Assert.assertEquals(loadedType, mockType);
        }
    }

    @Test
    public void testBigCreate() {
        Product.Type[] types = new Product.Type[1000];
        for(int i = 0; i < types.length; i++) {
            types[i] = new Product.Type();
            types[i].setName("Type " + i);
            session.persist(types[i]);
        }
        session.flush();
    }


}
