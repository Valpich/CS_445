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
public class CartTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() throws Exception {
    }

    @Test
    public void remove() throws Exception {
    }

    @Test
    public void add1() throws Exception {
    }

    @Test
    public void remove1() throws Exception {
    }

    @Test
    public void getProductList() throws Exception {
    }

    @Test
    public void setProductList() throws Exception {
    }

    @Test
    public void getServiceList() throws Exception {
    }

    @Test
    public void setServiceList() throws Exception {
    }

    @Test
    public void getListCount() throws Exception {
    }

    @Test
    public void setListCount() throws Exception {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Cart.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
