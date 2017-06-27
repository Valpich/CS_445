package iit.cs445.models.users;

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
public class AddressTest {

    private Address address;

    @Before
    public void setUp() throws Exception {
        address = new Address();
    }

    @After
    public void tearDown() throws Exception {
        address = null;
    }

    @Test
    public void getId() throws Exception {
        address.setId(1L);
        assertEquals(1L, (long)address.getId());
    }

    @Test
    public void setId() throws Exception {
        address.setId(1L);
        assertEquals(1L, (long)address.getId());
        address.setId(2L);
        assertEquals(2L, (long)address.getId());
    }

    @Test
    public void getPhoneNumber() throws Exception {
        address.setPhoneNumber("(123) 456-7890");
        assertEquals("(123) 456-7890", address.getPhoneNumber());
    }

    @Test
    public void setPhoneNumber() throws Exception {
        address.setPhoneNumber("(123) 456-7890");
        assertEquals("(123) 456-7890", address.getPhoneNumber());
        address.setPhoneNumber("+1 (123) 456-7890");
        assertEquals("+1 (123) 456-7890", address.getPhoneNumber());
    }

    @Test
    public void getStreetAddress() throws Exception {
        address.setStreetAddress("Street address");
        assertEquals("Street address", address.getStreetAddress());
    }

    @Test
    public void setStreetAddress() throws Exception {
        address.setStreetAddress("Street address");
        assertEquals("Street address", address.getStreetAddress());
        address.setStreetAddress("Street address two");
        assertEquals("Street address two", address.getStreetAddress());
    }

    @Test
    public void getFirstName() throws Exception {
        address.setFirstName("First name");
        assertEquals("First name", address.getFirstName());
    }

    @Test
    public void setFirstName() throws Exception {
        address.setFirstName("First name");
        assertEquals("First name", address.getFirstName());
        address.setFirstName("First name two");
        assertEquals("First name two", address.getFirstName());
    }

    @Test
    public void getLastName() throws Exception {
        address.setLastName("Last name");
        assertEquals("Last name", address.getLastName());
    }

    @Test
    public void setLastName() throws Exception {
        address.setLastName("Last name");
        assertEquals("Last name", address.getLastName());
        address.setLastName("Last name two");
        assertEquals("Last name two", address.getLastName());
    }

    @Test
    public void getZipCode() throws Exception {
        address.setZipCode("12345");
        assertEquals("12345", address.getZipCode());
    }

    @Test
    public void setZipCode() throws Exception {
        address.setZipCode("12345");
        assertEquals("12345", address.getZipCode());
        address.setZipCode("01234");
        assertEquals("01234", address.getZipCode());
    }

    @Test
    public void getCountry() throws Exception {
        address.setCountry("Country");
        assertEquals("Country", address.getCountry());
    }

    @Test
    public void setCountry() throws Exception {
        address.setCountry("Country");
        assertEquals("Country", address.getCountry());
        address.setCountry("Country two");
        assertEquals("Country two", address.getCountry());
    }

    @Test
    public void getCity() throws Exception {
        address.setCity("City");
        assertEquals("City", address.getCity());
    }

    @Test
    public void setCity() throws Exception {
        address.setCity("City");
        assertEquals("City", address.getCity());
        address.setCity("City two");
        assertEquals("City two", address.getCity());
    }

    @Test
    public void getState() throws Exception {
        address.setState("State");
        assertEquals("State", address.getState());
    }

    @Test
    public void setState() throws Exception {
        address.setState("State");
        assertEquals("State", address.getState());
        address.setState("State two");
        assertEquals("State two", address.getState());
    }

    @Test
    public void getUser() throws Exception {
        User user = new User();
        address.setUser(user);
        assertEquals(user, address.getUser());
    }

    @Test
    public void setUser() throws Exception {
        User user = new User();
        address.setUser(user);
        assertEquals(user, address.getUser());
        User userTwo = new User();
        address.setUser(userTwo);
        assertEquals(userTwo, address.getUser());
    }

    @Test
    public void toStringTest() throws Exception {
        assertNotNull(address.toString());
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Address.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
