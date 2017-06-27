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
public class LensTest {

    private Lens lens;

    @Before
    public void setUp() throws Exception {
        lens = new Lens();
    }

    @After
    public void tearDown() throws Exception {
        lens = null;
    }

    @Test
    public void getFocal() throws Exception {
        Float focal = 2F;
        lens.setFocal(focal);
        assertEquals(focal, lens.getFocal());
    }

    @Test
    public void setFocal() throws Exception {
        Float focal = 2F;
        lens.setFocal(focal);
        assertEquals(focal, lens.getFocal());
        Float focalTwo = 3F;
        lens.setFocal(focalTwo);
        assertEquals(focalTwo, lens.getFocal());
    }

    @Test
    public void getMagnification() throws Exception {
        Float magnification = 2F;
        lens.setMagnification(magnification);
        assertEquals(magnification, lens.getMagnification());
    }

    @Test
    public void setMagnification() throws Exception {
        Float magnification = 2F;
        lens.setMagnification(magnification);
        assertEquals(magnification, lens.getMagnification());
        Float magnificationTwo = 3F;
        lens.setMagnification(magnificationTwo);
        assertEquals(magnificationTwo, lens.getMagnification());
    }

    @Test
    public void toStringTest() throws Exception {
        assertNotNull(lens.toString());
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Lens.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
