import com.cloudteddy.gemcs01test.configuration.AppConfigure;
import com.cloudteddy.gemcs01test.service.ProductService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created by quanda on 22/01/2016.
 */
public class MainTest {

    AbstractApplicationContext context;
    ProductService productService;

    public void init(){
        context= new AnnotationConfigApplicationContext(AppConfigure.class);
        productService = (ProductService) context.getBean("productService");
    }

    @Test
    public void test1(){
        init();
        long[] expect = {7,8,9};


    }
}
