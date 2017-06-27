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

import java.util.ArrayList;
import java.util.List;

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
        List<AnalogRecordFormat> recordFormats = new ArrayList<>();
        recordFormats.add(AnalogRecordFormat.NTSC);
        analogDVR.setAnalogRecordFormats(recordFormats);
        assertEquals(recordFormats, analogDVR.getAnalogRecordFormats());
    }

    @Test
    public void setAnalogRecordFormats() throws Exception {
        List<AnalogRecordFormat> recordFormats = new ArrayList<>();
        recordFormats.add(AnalogRecordFormat.NTSC);
        analogDVR.setAnalogRecordFormats(recordFormats);
        assertEquals(recordFormats, analogDVR.getAnalogRecordFormats());
        List<AnalogRecordFormat> recordFormatsTwo = new ArrayList<>();
        recordFormatsTwo.add(AnalogRecordFormat.PAL);
        analogDVR.setAnalogRecordFormats(recordFormatsTwo);
        assertEquals(recordFormatsTwo, analogDVR.getAnalogRecordFormats());
    }

    @Test
    public void toStringTest() throws Exception {
        List<AnalogRecordFormat> recordFormats = new ArrayList<>();
        recordFormats.add(AnalogRecordFormat.NTSC);
        analogDVR.setAnalogRecordFormats(recordFormats);
        assertNotNull(analogDVR.toString());
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(AnalogDVR.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
