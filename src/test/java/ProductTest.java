import com.cloudteddy.gemcs01test.configuration.AppConfigure;
import com.cloudteddy.gemcs01test.dao.ProductDao;
import com.cloudteddy.gemcs01test.dao.ProductTypeDao;
import com.cloudteddy.gemcs01test.model.Product;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimtung on 25/01/16.
 */
public class ProductTest {

    private static AbstractApplicationContext context;
    private static ProductTypeDao productTypeDao;
    private static ProductDao productDao;

    @BeforeClass
    public static void before() {
        context = new AnnotationConfigApplicationContext(AppConfigure.class);
        productTypeDao = (ProductTypeDao) context.getBean("productType");
        productDao = (ProductDao) context.getBean("product");
    }

    @Test
    public void test() {
        Product.Type unit =  new Product.Type();
        unit.setName("unit");
        Product.Type part =  new Product.Type();
        part.setName("part");
        productTypeDao.save(unit);
        productTypeDao.save(part);
        Assert.assertEquals(2, productTypeDao.findAll().size());

        Product zenfone5 = new Product("zenfone5", unit);
        Product iphone5s = new Product("iphone5s", unit);
        Product xperiaz5 = new Product("xperiaz5", unit);
        productDao.save(zenfone5);
        productDao.save(iphone5s);
        productDao.save(xperiaz5);
        Assert.assertEquals(3, productDao.findAll().size());

        List<Product> unitProducts = productDao.findByType(unit);
        Assert.assertEquals(3, unitProducts.size());
        List<Product> partProducts = productDao.findByType(part);
        Assert.assertEquals(0, partProducts.size());

        productTypeDao.delete(unit.getId());
        Assert.assertEquals(1, productTypeDao.findAll().size());
        Assert.assertEquals(0, productDao.findAll().size());



    }

}
