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
public class DigitalSurveillanceCameraTest {

    private DigitalSurveillanceCamera digitalSurveillanceCamera;

    @Before
    public void setUp() throws Exception {
        digitalSurveillanceCamera = new DigitalSurveillanceCamera();
    }

    @After
    public void tearDown() throws Exception {
        digitalSurveillanceCamera = null;
    }

    @Test
    public void toStringTest() throws Exception {
        assertNotNull(digitalSurveillanceCamera.toString());
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(DigitalSurveillanceCamera.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
