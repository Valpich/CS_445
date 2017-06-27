package iit.cs445.models.orders;

import iit.cs445.models.products.Product;
import iit.cs445.models.services.Service;
import iit.cs445.models.users.OrderAddress;
import iit.cs445.models.users.User;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Arquillian.class)
public class OrderTest {

    private Order order;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Order.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Before
    public void setUp() throws Exception {
        order = new Order();
    }

    @After
    public void tearDown() throws Exception {
        order = null;
    }

    @Test
    public void getId() throws Exception {
        order.setId(2L);
        assertEquals(2L, order.getId().longValue());
    }

    @Test
    public void setId() throws Exception {
        order.setId(2L);
        assertEquals(2L, order.getId().longValue());
        order.setId(3L);
        assertEquals(3L, order.getId().longValue());
    }

    @Test
    public void getStatus() throws Exception {
        order.setStatus(OrderStatus.PROCESSING);
        assertEquals(OrderStatus.PROCESSING, order.getStatus());
    }

    @Test
    public void setStatus() throws Exception {
        order.setStatus(OrderStatus.PROCESSING);
        assertEquals(OrderStatus.PROCESSING, order.getStatus());
        order.setStatus(OrderStatus.SHIPPED);
        assertEquals(OrderStatus.SHIPPED, order.getStatus());
    }

    @Test
    public void getOrderedProducts() throws Exception {
        List<Product> orderedProducts = new ArrayList<>();
        order.setOrderedProducts(orderedProducts);
        assertEquals(orderedProducts, order.getOrderedProducts());
    }

    @Test
    public void setOrderedProducts() throws Exception {
        List<Product> orderedProducts = new ArrayList<>();
        order.setOrderedProducts(orderedProducts);
        assertEquals(orderedProducts, order.getOrderedProducts());
        List<Product> orderedProductsTwo = new ArrayList<>();
        order.setOrderedProducts(orderedProductsTwo);
        assertEquals(orderedProductsTwo, order.getOrderedProducts());
    }

    @Test
    public void getOrderedServices() throws Exception {
        List<Service> orderedServices = new ArrayList<>();
        order.setOrderedServices(orderedServices);
        assertEquals(orderedServices, order.getOrderedServices());
    }

    @Test
    public void setOrderedServices() throws Exception {
        List<Service> orderedServices = new ArrayList<>();
        order.setOrderedServices(orderedServices);
        assertEquals(orderedServices, order.getOrderedServices());
        List<Service> orderedServicesTwo = new ArrayList<>();
        order.setOrderedServices(orderedServicesTwo);
        assertEquals(orderedServicesTwo, order.getOrderedServices());
    }

    @Test
    public void getOrderAddress() throws Exception {
        OrderAddress address = new OrderAddress();
        order.setOrderAddress(address);
        assertEquals(address, order.getOrderAddress());
    }

    @Test
    public void setOrderAddress() throws Exception {
        OrderAddress address = new OrderAddress();
        order.setOrderAddress(address);
        assertEquals(address, order.getOrderAddress());
        OrderAddress addressTwo = new OrderAddress();
        order.setOrderAddress(addressTwo);
        assertEquals(addressTwo, order.getOrderAddress());
    }

    @Test
    public void getUser() throws Exception {
        User user = new User();
        order.setUser(user);
        assertEquals(user, order.getUser());
    }

    @Test
    public void setUser() throws Exception {
        User user = new User();
        user.setId(1L);
        order.setUser(user);
        assertEquals(user, order.getUser());
        User userTwo = new User();
        userTwo.setId(2L);
        order.setUser(userTwo);
        assertEquals(userTwo, order.getUser());
    }

    @Test
    public void toStringTest() throws Exception {
        order.setId(2L);
        order.setStatus(OrderStatus.PROCESSING);
        List<Product> orderedProducts = new ArrayList<>();
        order.setOrderedProducts(orderedProducts);
        List<Service> orderedServices = new ArrayList<>();
        order.setOrderedServices(orderedServices);
        OrderAddress address = new OrderAddress();
        order.setOrderAddress(address);
        User user = new User();
        user.setId(1L);
        order.setUser(user);
        assertNotNull(order.toString());
    }

}
