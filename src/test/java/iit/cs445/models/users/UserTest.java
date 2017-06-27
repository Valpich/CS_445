package iit.cs445.models.users;

import iit.cs445.models.orders.Order;
import org.aspectj.weaver.ast.Or;
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

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class UserTest {

    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
    }

    @After
    public void tearDown() throws Exception {
        user = null;
    }

    @Test
    public void getId() throws Exception {
        user.setId(1L);
        assertEquals(1L, (long)user.getId());
    }

    @Test
    public void setId() throws Exception {
        user.setId(1L);
        assertEquals(1L, (long)user.getId());
        user.setId(2L);
        assertEquals(2L, (long)user.getId());
    }

    @Test
    public void getEmail() throws Exception {
        user.setEmail("email@test.com");
        assertEquals("email@test.com", user.getEmail());
    }

    @Test
    public void setEmail() throws Exception {
        user.setEmail("email@test.com");
        assertEquals("email@test.com", user.getEmail());
        user.setEmail("email@test.us");
        assertEquals("email@test.us", user.getEmail());
    }

    @Test
    public void getFirstName() throws Exception {
        user.setFirstName("First name");
        assertEquals("First name", user.getFirstName());
    }

    @Test
    public void setFirstName() throws Exception {
        user.setFirstName("First name");
        assertEquals("First name", user.getFirstName());
        user.setFirstName("First name two");
        assertEquals("First name two", user.getFirstName());
    }

    @Test
    public void getLastName() throws Exception {
        user.setLastName("Last name");
        assertEquals("Last name", user.getLastName());
    }

    @Test
    public void setLastName() throws Exception {
        user.setLastName("Last name");
        assertEquals("Last name", user.getLastName());
        user.setLastName("Last name two");
        assertEquals("Last name two", user.getLastName());
    }

    @Test
    public void getPassword() throws Exception {
        user.setPassword("password");
        assertEquals("password", user.getPassword());
    }

    @Test
    public void setPassword() throws Exception {
        user.setPassword("password");
        assertEquals("password", user.getPassword());
        user.setPassword("pass");
        assertEquals("pass",user.getPassword());
    }

    @Test
    public void getAddresses() throws Exception {
        List<Address> addressList = new ArrayList<>();
        user.setAddresses(addressList);
        assertEquals(addressList, user.getAddresses());
    }

    @Test
    public void setAddresses() throws Exception {
        List<Address> addressList = new ArrayList<>();
        user.setAddresses(addressList);
        assertEquals(addressList, user.getAddresses());
        List<Address> addressListTwo = new ArrayList<>();
        user.setAddresses(addressListTwo);
        assertEquals(addressListTwo, user.getAddresses());
    }

    @Test
    public void getOrders() throws Exception {
        boolean exception = false;
        try{
            List<Order> orderList = new ArrayList<>();
            assertEquals(orderList, user.getOrders());
        }catch (NullPointerException npe){
            exception = true;
        }
        assertEquals(true, exception);
    }

    @Test
    public void setOrders() throws Exception {
        boolean exception = false;
        try{
            List<Order> orderList = new ArrayList<>();
            user.setOrders(orderList);
            assertEquals(orderList, user.getOrders());
            List<Order> orderListTwo = new ArrayList<>();
            user.setOrders(orderListTwo);
            assertEquals(orderListTwo, user.getOrders());
        }catch (NullPointerException npe){
            exception = true;
        }
        assertEquals(true, exception);
    }

    @Test
    public void update() throws Exception {
            boolean exception = false;
            try{
                user.update();
            }catch (NullPointerException npe){
                exception = true;
            }
            assertEquals(true, exception);
    }

    @Test
    public void toStringTest() throws Exception {
        assertNotNull(user.toString());
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(User.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
