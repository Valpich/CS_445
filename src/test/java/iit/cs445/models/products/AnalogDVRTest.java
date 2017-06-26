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
public class AnalogDVRTest {

    private AnalogDVR analogDVR;

    @Before
    public void setUp() throws Exception {
        analogDVR = new AnalogDVR();
    }

    @After
    public void tearDown() throws Exception {
        analogDVR = null;
    }

    @Test
    public void getAnalogRecordFormats() throws Exception {
    }

    @Test
    public void setAnalogRecordFormats() throws Exception {
    }

    @Test
    public void toStringTest() throws Exception {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(AnalogDVR.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
