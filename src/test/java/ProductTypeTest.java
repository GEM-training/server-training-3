import com.cloudteddy.gemcs01test.configuration.AppConfigure;
import com.cloudteddy.gemcs01test.dao.ProductTypeDao;
import com.cloudteddy.gemcs01test.model.Product;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by kimtung on 1/22/16.
 */
public class ProductTypeTest {

    private static AbstractApplicationContext context;
    private static ProductTypeDao productTypeDao;

    @BeforeClass
    public static void before() {
        context = new AnnotationConfigApplicationContext(AppConfigure.class);
        productTypeDao = (ProductTypeDao) context.getBean("productType");
    }

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
        if (retrievedType != null) {
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
        if (loadedType != null) {
            Assert.assertEquals(loadedType, mockType);
            loadedType.setName("testUpdateSucceeded");
            mockType.setName("testUpdateSucceeded");
            productTypeDao.update(loadedType);
        }

        loadedType = productTypeDao.findById(mockType.getId());
        if (loadedType != null) {
            Assert.assertEquals(loadedType, mockType);
        }
    }

    @AfterClass
    public static void after() {
        Session session = ((SessionFactory) context.getBean("sessionFactory")).openSession();
        SQLQuery sqlQuery = session.createSQLQuery("DELETE FROM product_type WHERE  1=1");
        sqlQuery.executeUpdate();
        session.flush();
        session.close();
    }

}
