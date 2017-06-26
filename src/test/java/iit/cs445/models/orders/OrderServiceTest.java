package iit.cs445.models.orders;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class OrderServiceTest {

    private OrderService orderService;

    @Before
    public void setUp() throws Exception {
        orderService = new OrderManager();
    }

    @After
    public void tearDown() throws Exception {
        orderService = null;
    }

    @Test
    public void createNewOrder() throws Exception {
    }

    @Test
    public void updateOrder() throws Exception {
    }

    @Test
    public void deleteOrder() throws Exception {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(OrderService.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
