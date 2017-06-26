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
    }

    @Test
    public void setId() throws Exception {
    }

    @Test
    public void getEmail() throws Exception {
    }

    @Test
    public void setEmail() throws Exception {
    }

    @Test
    public void getFirstName() throws Exception {
    }

    @Test
    public void setFirstName() throws Exception {
    }

    @Test
    public void getLastName() throws Exception {
    }

    @Test
    public void setLastName() throws Exception {
    }

    @Test
    public void getPassword() throws Exception {
    }

    @Test
    public void setPassword() throws Exception {
    }

    @Test
    public void getAddresses() throws Exception {
    }

    @Test
    public void setAddresses() throws Exception {
    }

    @Test
    public void getOrders() throws Exception {
    }

    @Test
    public void setOrders() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void toStringTest() throws Exception {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(User.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
