import com.cloudteddy.gemcs01test.configuration.AppConfigure;
import com.cloudteddy.gemcs01test.dao.ProductDao;
import com.cloudteddy.gemcs01test.dao.ProductTypeDao;
import com.cloudteddy.gemcs01test.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by kimtung on 25/01/16.
 */
public class ProductTest {

    private static AbstractApplicationContext context;
    private static ProductTypeDao productTypeDao;
    private static ProductDao productDao;

    @BeforeClass
    public static void beforeClass() {
        context = new AnnotationConfigApplicationContext(AppConfigure.class);
        productTypeDao = (ProductTypeDao) context.getBean("productType");
        productDao = (ProductDao) context.getBean("product");
    }

    @AfterClass
    public static void afterClass() {
        Session session = ((SessionFactory) context.getBean("sessionFactory")).openSession();
        session.createSQLQuery("DELETE FROM product WHERE 1=1").executeUpdate();
        session.createSQLQuery("DELETE FROM product_type WHERE 1=1").executeUpdate();
        session.flush();
        session.close();
    }

    @Test
    public void dataInitialize() {
        Product.Type unit =  new Product.Type();
        unit.setName("unit");
        Product.Type part =  new Product.Type();
        part.setName("part");
        productTypeDao.save(unit);
        productTypeDao.save(part);
        Assert.assertEquals(2, productTypeDao.findAll().size());

        Product.Type loadedUnit = productTypeDao.findById(unit.getId());
        Product.Type loadedPart = productTypeDao.findById(part.getId());
        Assert.assertEquals(loadedPart, part);
        Assert.assertEquals(loadedUnit, unit);

        Product zenfone5 = new Product("zenfone5", unit);
        Product iphone5s = new Product("iphone5s", unit);
        Product xperiaz5 = new Product("xperiaz5", unit);
        Product battery = new Product("battery", part);
        Product screen = new Product("screen", part);
        productDao.save(zenfone5);
        productDao.save(iphone5s);
        productDao.save(xperiaz5);
        productDao.save(battery);
        productDao.save(screen);
        Assert.assertEquals(5, productDao.findAll().size());
        Assert.assertEquals(3, productDao.findByType(unit).size());
        Assert.assertEquals(2, productDao.findByType(part).size());
    }

    @Test(dependsOnMethods = "dataInitialize", priority = 1)
    public void deleteProduct() {
        productDao.delete(2);
        Assert.assertNull(productDao.findById(2));
        Assert.assertEquals(4, productDao.findAll().size());
        Assert.assertEquals(2, productTypeDao.findAll().size());
    }

    @Test(dependsOnMethods = "dataInitialize", priority = 2)
    public void deleteProductType() {
        Product.Type type = productTypeDao.findById(2);
        productTypeDao.delete(2);
        Assert.assertNull(productTypeDao.findById(2));
        Assert.assertEquals(1, productTypeDao.findAll().size());
        Assert.assertEquals(2, productDao.findAll().size());
        Assert.assertThrows(() -> {
            productDao.findByType(type);
        });
    }


}
