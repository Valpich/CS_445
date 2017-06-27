package iit.cs445.models.services;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Arquillian.class)
public class ServiceTest {

    private ServiceClassTest serviceClassTest;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Service.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Before
    public void setUp() throws Exception {
        serviceClassTest = new ServiceClassTest();
    }

    @After
    public void tearDown() throws Exception {
        serviceClassTest = null;
    }

    @Test
    public void getId() throws Exception {
        Long id = 2L;
        serviceClassTest.setId(id);
        assertEquals(2L, (long) serviceClassTest.getId());
    }

    @Test
    public void setId() throws Exception {
        Long id = 2L;
        serviceClassTest.setId(id);
        assertEquals(2L, (long) serviceClassTest.getId());
        Long idTwo = 3L;
        serviceClassTest.setId(idTwo);
        assertEquals(3L, (long) serviceClassTest.getId());
    }

    @Test
    public void getPrice() throws Exception {
        Float price = 20F;
        serviceClassTest.setPrice(price);
        assertEquals(new Float(20F), serviceClassTest.getPrice());
    }

    @Test
    public void setPrice() throws Exception {
        Float price = 20F;
        serviceClassTest.setPrice(price);
        assertEquals(new Float(20F), serviceClassTest.getPrice());
        Float priceTwo = 30F;
        serviceClassTest.setPrice(priceTwo);
        assertEquals(new Float(30F), serviceClassTest.getPrice());
    }

    @Test
    public void getDescription() throws Exception {
        serviceClassTest.setDescription("Description");
        assertEquals("Description", serviceClassTest.getDescription());
    }

    @Test
    public void setDescription() throws Exception {
        serviceClassTest.setDescription("Description");
        assertEquals("Description", serviceClassTest.getDescription());
        serviceClassTest.setDescription("DescriptionTwo");
        assertEquals("DescriptionTwo", serviceClassTest.getDescription());
    }

    @Test
    public void getDeleted() throws Exception {
        assertEquals(false, serviceClassTest.getDeleted());
    }

    @Test
    public void setDeleted() throws Exception {
        assertEquals(false, serviceClassTest.getDeleted());
        serviceClassTest.setDeleted(true);
        assertEquals(true, serviceClassTest.getDeleted());
    }

    @Test
    public void toStringTest() throws Exception {
        assertNotNull(serviceClassTest.toString());
    }

    private class ServiceClassTest extends Service<ServiceClassTest> {
    }

}
