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

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class CableTest {

    private Cable cable;

    @Before
    public void setUp() throws Exception {
        cable = new Cable();
    }

    @After
    public void tearDown() throws Exception {
        cable = null;
    }

    @Test
    public void getLength() throws Exception {
        Float value = 2F;
        cable.setLength(value);
        assertEquals(value, cable.getLength());
    }

    @Test
    public void setLength() throws Exception {
        Float value = 2F;
        cable.setLength(value);
        assertEquals(value, cable.getLength());
        Float valueTwo = 3F;
        cable.setLength(valueTwo);
        assertEquals(valueTwo, cable.getLength());
    }

    @Test
    public void toStringTest() throws Exception {
        assertNotNull(cable.toString());
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Cable.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
