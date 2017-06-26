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

/**
 * Created by valentinpichavant on 6/26/17.
 */
@RunWith(Arquillian.class)
public class OrderAddressTest {
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
    public void getPhoneNumber() throws Exception {
    }

    @Test
    public void setPhoneNumber() throws Exception {
    }

    @Test
    public void getStreetAddress() throws Exception {
    }

    @Test
    public void setStreetAddress() throws Exception {
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
    public void getZipCode() throws Exception {
    }

    @Test
    public void setZipCode() throws Exception {
    }

    @Test
    public void getCountry() throws Exception {
    }

    @Test
    public void setCountry() throws Exception {
    }

    @Test
    public void getCity() throws Exception {
    }

    @Test
    public void setCity() throws Exception {
    }

    @Test
    public void getState() throws Exception {
    }

    @Test
    public void setState() throws Exception {
    }

    @Test
    public void getOrder() throws Exception {
    }

    @Test
    public void setOrder() throws Exception {
    }

    @Test
    public void clone() throws Exception {
    }

    @Test
    public void toString() throws Exception {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(OrderAddress.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
