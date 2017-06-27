package iit.cs445.models.products;

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
public class MonitorTest {

    private Monitor monitor;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Monitor.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Before
    public void setUp() throws Exception {
        monitor = new Monitor();
    }

    @After
    public void tearDown() throws Exception {
        monitor = null;
    }

    @Test
    public void getSize() throws Exception {
        Float size = 100F;
        monitor.setSize(size);
        assertEquals(size, monitor.getSize());
    }

    @Test
    public void setSize() throws Exception {
        Float size = 100F;
        monitor.setSize(size);
        assertEquals(size, monitor.getSize());
        Float sizeTwo = 15F;
        monitor.setSize(sizeTwo);
        assertEquals(sizeTwo, monitor.getSize());
    }

    @Test
    public void getMaxResolution() throws Exception {
        monitor.setMaxResolution("1080p");
        assertEquals("1080p", monitor.getMaxResolution());
    }

    @Test
    public void setMaxResolution() throws Exception {
        monitor.setMaxResolution("1080p");
        assertEquals("1080p", monitor.getMaxResolution());
        monitor.setMaxResolution("4K");
        assertEquals("4K", monitor.getMaxResolution());
    }

    @Test
    public void toStringTest() throws Exception {
        assertNotNull(monitor.toString());
    }

}
