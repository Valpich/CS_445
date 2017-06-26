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
public class UserServiceTest {

    private class UserServiceImplementationTest implements UserService{}
    private UserServiceImplementationTest userServiceImplementationTest;

    @Before
    public void setUp() throws Exception {
        userServiceImplementationTest = new UserServiceImplementationTest();
    }

    @After
    public void tearDown() throws Exception {
        userServiceImplementationTest = null;
    }

    @Test
    public void registerNewUser() throws Exception {
    }

    @Test
    public void updateUser() throws Exception {
    }

    @Test
    public void deleteUser() throws Exception {
    }

    @Test
    public void findUserByMail() throws Exception {
    }

    @Test
    public void findUserById() throws Exception {
    }

    @Test
    public void authenticateUser() throws Exception {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(UserService.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}