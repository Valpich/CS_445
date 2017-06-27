package iit.cs445.models.products;

import iit.cs445.models.orders.OrderType;
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
public class ProductTest {

    private class ProductClassTest extends Product<ProductClassTest>{}
    private ProductClassTest productClassTest;

    @Before
    public void setUp() throws Exception {
        productClassTest = new ProductClassTest();
    }

    @After
    public void tearDown() throws Exception {
        productClassTest = null;
    }

    @Test
    public void getId() throws Exception {
        Long id = 2L;
        productClassTest.setId(id);
        assertEquals(id, productClassTest.getId());
    }

    @Test
    public void setId() throws Exception {
        Long id = 2L;
        productClassTest.setId(id);
        assertEquals(id, productClassTest.getId());
        Long idTwo = 3L;
        productClassTest.setId(idTwo);
        assertEquals(idTwo, productClassTest.getId());
    }

    @Test
    public void getPrice() throws Exception {
        Float price = 30F;
        productClassTest.setPrice(price);
        assertEquals(price, productClassTest.getPrice());
    }

    @Test
    public void setPrice() throws Exception {
        Float price = 30F;
        productClassTest.setPrice(price);
        assertEquals(price, productClassTest.getPrice());
        Float priceTwo = 50F;
        productClassTest.setPrice(priceTwo);
        assertEquals(priceTwo, productClassTest.getPrice());
    }

    @Test
    public void getOrderType() throws Exception {
        productClassTest.setOrderType(OrderType.BUY);
        assertEquals(OrderType.BUY, productClassTest.getOrderType());
    }

    @Test
    public void setOrderType() throws Exception {
        productClassTest.setOrderType(OrderType.BUY);
        assertEquals(OrderType.BUY, productClassTest.getOrderType());
        productClassTest.setOrderType(OrderType.INSTALL);
        assertEquals(OrderType.INSTALL, productClassTest.getOrderType());
    }

    @Test
    public void getDescription() throws Exception {
        productClassTest.setDescription("Description");
        assertEquals("Description", productClassTest.getDescription());
    }

    @Test
    public void setDescription() throws Exception {
        productClassTest.setDescription("Description");
        assertEquals("Description", productClassTest.getDescription());
        productClassTest.setDescription("DescriptionTwo");
        assertEquals("DescriptionTwo", productClassTest.getDescription());
    }

    @Test
    public void getDeleted() throws Exception {
        productClassTest.setDeleted(true);
        assertEquals(true, productClassTest.getDeleted());
    }

    @Test
    public void setDeleted() throws Exception {
        productClassTest.setDeleted(true);
        assertEquals(true, productClassTest.getDeleted());
        productClassTest.setDeleted(false);
        assertEquals(false, productClassTest.getDeleted());
    }

    @Test
    public void toStringTest() throws Exception {
        assertNotNull(productClassTest.toString());
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Product.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
