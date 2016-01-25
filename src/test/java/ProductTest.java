import com.cloudteddy.gemcs01test.configuration.AppConfigure;
import com.cloudteddy.gemcs01test.dao.ProductDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created by quanda on 25/01/2016.
 */
public class ProductTest {
    private ProductDao productDao;
    private static AbstractApplicationContext context;
    private static SessionFactory sessionFactory;
    private static Session session;

    @BeforeClass
    public static void before() {
        context = new AnnotationConfigApplicationContext(AppConfigure.class);
        sessionFactory = (SessionFactory) context.getBean("sessionFactory");
    }

    @Test
    public void testCreateAndRead(){
        Transaction transaction = session.beginTransaction();

    }


}
