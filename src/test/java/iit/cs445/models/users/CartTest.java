package iit.cs445.models.users;

import iit.cs445.models.products.Product;
import iit.cs445.models.services.Service;
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
public class CartTest {

    private Cart cart;

    @Before
    public void setUp() throws Exception {
        cart = new Cart();
    }

    @After
    public void tearDown() throws Exception {
        cart = null;
    }

    @Test
    public void add() throws Exception {
        assertEquals(0, cart.getProductList().size());
        Product product = new Product() {
            @Override
            public Long getId() {
                return -10L;
            }
        };
        cart.add(product);
        assertEquals(1, cart.getProductList().size());
        assertEquals(0, cart.getServiceList().size());
        Service service = new Service() {
            @Override
            public Long getId() {
                return -10L;
            }
        };
        cart.add(service);
        assertEquals(1, cart.getServiceList().size());
    }

    @Test
    public void remove() throws Exception {
        assertEquals(0, cart.getProductList().size());
        Product product = new Product() {
            @Override
            public Long getId() {
                return -10L;
            }
        };
        cart.add(product);
        assertEquals(1, cart.getProductList().size());
        cart.remove(product);
        assertEquals(0, cart.getProductList().size());
        assertEquals(0, cart.getServiceList().size());
        Service service = new Service() {
            @Override
            public Long getId() {
                return -10L;
            }
        };
        cart.add(service);
        assertEquals(1, cart.getServiceList().size());
        cart.remove(service);
        assertEquals(0, cart.getServiceList().size());
    }

    @Test
    public void getProductList() throws Exception {
        List<Product> productList = new ArrayList<>();
        cart.setProductList(productList);
        assertEquals(productList, cart.getProductList());
    }

    @Test
    public void setProductList() throws Exception {
        List<Product> productList = new ArrayList<>();
        cart.setProductList(productList);
        assertEquals(productList, cart.getProductList());
        List<Product> productListTwo = new ArrayList<>();
        cart.setProductList(productListTwo);
        assertEquals(productListTwo, cart.getProductList());
    }

    @Test
    public void getServiceList() throws Exception {
        List<Service> serviceList = new ArrayList<>();
        cart.setServiceList(serviceList);
        assertEquals(serviceList, cart.getServiceList());
    }

    @Test
    public void setServiceList() throws Exception {
        List<Service> serviceList = new ArrayList<>();
        cart.setServiceList(serviceList);
        assertEquals(serviceList, cart.getServiceList());
        List<Service> serviceListTwo = new ArrayList<>();
        cart.setServiceList(serviceListTwo);
        assertEquals(serviceListTwo, cart.getServiceList());
    }

    @Test
    public void getListCount() throws Exception {
        assertEquals(0, (long) cart.getListCount());
        Product product = new Product() {
            @Override
            public Long getId() {
                return -10L;
            }
        };
        cart.add(product);
        assertEquals(1, (long) cart.getListCount());
    }

    @Test
    public void toStringTest() throws Exception {
        assertNotNull(cart.toString());
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Cart.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
