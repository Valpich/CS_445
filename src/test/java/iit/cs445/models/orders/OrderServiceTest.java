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

    private class OrderServiceImplementTest implements OrderService{}

    private OrderServiceImplementTest orderServiceImplementTest;

    @Before
    public void setUp() throws Exception {
        orderServiceImplementTest = new OrderServiceImplementTest();
    }

    @After
    public void tearDown() throws Exception {
        orderServiceImplementTest = null;
    }

    @Test
    public void createNewOrder() throws Exception {
        assertEquals(null, orderServiceImplementTest.createNewOrder(new Order()));
    }

    @Test
    public void updateOrder() throws Exception {
        assertEquals(null, orderServiceImplementTest.updateOrder(new Order()));
    }

    @Test
    public void deleteOrder() throws Exception {
        assertEquals(null, orderServiceImplementTest.deleteOrder(new Order()));
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(OrderService.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
