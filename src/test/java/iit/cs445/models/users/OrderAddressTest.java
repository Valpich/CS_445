package iit.cs445.models.users;

import iit.cs445.models.orders.Order;
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
public class OrderAddressTest {

    private OrderAddress orderAddress;

    @Before
    public void setUp() throws Exception {
        orderAddress = new OrderAddress();
    }

    @After
    public void tearDown() throws Exception {
        orderAddress = null;
    }

    @Test
    public void getId() throws Exception {
        orderAddress.setId(1L);
        assertEquals(1L, (long)orderAddress.getId());
    }

    @Test
    public void setId() throws Exception {
        orderAddress.setId(1L);
        assertEquals(1L, (long)orderAddress.getId());
        orderAddress.setId(2L);
        assertEquals(2L, (long)orderAddress.getId());
    }

    @Test
    public void getPhoneNumber() throws Exception {
        orderAddress.setPhoneNumber("(123) 456-7890");
        assertEquals("(123) 456-7890", orderAddress.getPhoneNumber());
    }

    @Test
    public void setPhoneNumber() throws Exception {
        orderAddress.setPhoneNumber("(123) 456-7890");
        assertEquals("(123) 456-7890", orderAddress.getPhoneNumber());
        orderAddress.setPhoneNumber("+1 (123) 456-7890");
        assertEquals("+1 (123) 456-7890", orderAddress.getPhoneNumber());
    }

    @Test
    public void getStreetAddress() throws Exception {
        orderAddress.setStreetAddress("Street address");
        assertEquals("Street address", orderAddress.getStreetAddress());
    }

    @Test
    public void setStreetAddress() throws Exception {
        orderAddress.setStreetAddress("Street address");
        assertEquals("Street address", orderAddress.getStreetAddress());
        orderAddress.setStreetAddress("Street address two");
        assertEquals("Street address two", orderAddress.getStreetAddress());
    }

    @Test
    public void getFirstName() throws Exception {
        orderAddress.setFirstName("First name");
        assertEquals("First name", orderAddress.getFirstName());
    }

    @Test
    public void setFirstName() throws Exception {
        orderAddress.setFirstName("First name");
        assertEquals("First name", orderAddress.getFirstName());
        orderAddress.setFirstName("First name two");
        assertEquals("First name two", orderAddress.getFirstName());
    }

    @Test
    public void getLastName() throws Exception {
        orderAddress.setLastName("Last name");
        assertEquals("Last name", orderAddress.getLastName());
    }

    @Test
    public void setLastName() throws Exception {
        orderAddress.setLastName("Last name");
        assertEquals("Last name", orderAddress.getLastName());
        orderAddress.setLastName("Last name two");
        assertEquals("Last name two", orderAddress.getLastName());
    }

    @Test
    public void getZipCode() throws Exception {
        orderAddress.setZipCode("12345");
        assertEquals("12345", orderAddress.getZipCode());
    }

    @Test
    public void setZipCode() throws Exception {
        orderAddress.setZipCode("12345");
        assertEquals("12345", orderAddress.getZipCode());
        orderAddress.setZipCode("01234");
        assertEquals("01234", orderAddress.getZipCode());
    }

    @Test
    public void getCountry() throws Exception {
        orderAddress.setCountry("Country");
        assertEquals("Country", orderAddress.getCountry());
    }

    @Test
    public void setCountry() throws Exception {
        orderAddress.setCountry("Country");
        assertEquals("Country", orderAddress.getCountry());
        orderAddress.setCountry("Country two");
        assertEquals("Country two", orderAddress.getCountry());
    }

    @Test
    public void getCity() throws Exception {
        orderAddress.setCity("City");
        assertEquals("City", orderAddress.getCity());
    }

    @Test
    public void setCity() throws Exception {
        orderAddress.setCity("City");
        assertEquals("City", orderAddress.getCity());
        orderAddress.setCity("City two");
        assertEquals("City two", orderAddress.getCity());
    }

    @Test
    public void getState() throws Exception {
        orderAddress.setState("State");
        assertEquals("State", orderAddress.getState());
    }

    @Test
    public void setState() throws Exception {
        orderAddress.setState("State");
        assertEquals("State", orderAddress.getState());
        orderAddress.setState("State two");
        assertEquals("State two", orderAddress.getState());
    }

    @Test
    public void getOrder() throws Exception {
        Order order = new Order();
        orderAddress.setOrder(order);
        assertEquals(order, orderAddress.getOrder());
    }

    @Test
    public void setOrder() throws Exception {
        Order order = new Order();
        orderAddress.setOrder(order);
        assertEquals(order, orderAddress.getOrder());
        Order orderTwo = new Order();
        orderAddress.setOrder(orderTwo);
        assertEquals(orderTwo, orderAddress.getOrder());
    }

    @Test
    public void cloneTest() throws Exception {
        assertNotNull(orderAddress.clone(new Address()));
    }

    @Test
    public void toStringTest() throws Exception {
        assertNotNull(orderAddress.toString());
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(OrderAddress.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
