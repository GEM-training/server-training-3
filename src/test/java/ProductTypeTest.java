import com.cloudteddy.gemcs01test.configuration.AppConfigure;
import com.cloudteddy.gemcs01test.dao.ProductTypeDao;
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
    private static ProductTypeDao productTypeDao;

    @BeforeClass
    public static void before() {
        context = new AnnotationConfigApplicationContext(AppConfigure.class);
        sessionFactory = (SessionFactory) context.getBean("sessionFactory");
        productTypeDao = (ProductTypeDao) context.getBean("productType");
        session = sessionFactory.openSession();
    }

//    @AfterClass
//    public static void after() {
//        context = null;
//        sessionFactory.close();
//        session.close();
//    }

    @Test
    public void testCreateAndRead() {
        Product.Type unit = new Product.Type();
        unit.setName("testInsert1");
        Product.Type part = new Product.Type();
        part.setName("testInsert2");

        productTypeDao.save(unit);
        productTypeDao.save(part);

        List<Product.Type> types = productTypeDao.findAll();

        Assert.assertNotNull(types);
        Assert.assertEquals(2, types.size());

        Assert.assertEquals(unit, types.get(0));
        Assert.assertEquals(part, types.get(1));
    }

    @Test
    public void testDelete() {
        Product.Type mockType = new Product.Type();
        mockType.setName("testDelete");
        productTypeDao.save(mockType);

        Product.Type retrievedType = productTypeDao.findById(mockType.getId());
        if(retrievedType != null) {
            productTypeDao.delete(retrievedType.getId());
        }

        retrievedType = productTypeDao.findById(mockType.getId());
        Assert.assertNull(retrievedType);
    }

    @Test
    public void testUpdate() {
        Product.Type mockType = new Product.Type();
        mockType.setName("testUpdateFailed");
        productTypeDao.save(mockType);

        Product.Type loadedType = productTypeDao.findById(mockType.getId());
        if(loadedType != null) {
            Assert.assertEquals(loadedType, mockType);
            loadedType.setName("testUpdateSucceeded");
            mockType.setName("testUpdateSucceeded");
            productTypeDao.update(loadedType);
        }

        loadedType = productTypeDao.findById(mockType.getId());
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
    }


}
