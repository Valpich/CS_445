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
public class OrderTest {

    private Order order;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getId() throws Exception {
    }

    @Test
    public void setId() throws Exception {
    }

    @Test
    public void getStatus() throws Exception {
    }

    @Test
    public void setStatus() throws Exception {
    }

    @Test
    public void getOrderedProducts() throws Exception {
    }

    @Test
    public void setOrderedProducts() throws Exception {
    }

    @Test
    public void getOrderedServices() throws Exception {
    }

    @Test
    public void setOrderedServices() throws Exception {
    }

    @Test
    public void getOrderAddress() throws Exception {
    }

    @Test
    public void setOrderAddress() throws Exception {
    }

    @Test
    public void getUser() throws Exception {
    }

    @Test
    public void setUser() throws Exception {
    }

    @Test
    public void toStringTest() throws Exception {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Order.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
