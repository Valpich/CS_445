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
public class MicrophoneTest {

    private Microphone microphone;

    @Before
    public void setUp() throws Exception {
        microphone = new Microphone();
    }

    @After
    public void tearDown() throws Exception {
        microphone = null;
    }

    @Test
    public void getBattery() throws Exception {
        Boolean bool = true;
        microphone.setBattery(bool);
        assertEquals(bool,microphone.getBattery());
    }

    @Test
    public void setBattery() throws Exception {
        Boolean bool = true;
        microphone.setBattery(bool);
        assertEquals(bool,microphone.getBattery());
        Boolean boolTwo = false;
        microphone.setBattery(boolTwo);
        assertEquals(boolTwo,microphone.getBattery());
    }

    @Test
    public void getMicrophoneType() throws Exception {
        microphone.setMicrophoneType(MicrophoneType.CONDENSER);
        assertEquals(MicrophoneType.CONDENSER, microphone.getMicrophoneType());
    }

    @Test
    public void setMicrophoneType() throws Exception {
        microphone.setMicrophoneType(MicrophoneType.CONDENSER);
        assertEquals(MicrophoneType.CONDENSER, microphone.getMicrophoneType());
        microphone.setMicrophoneType(MicrophoneType.CARBON);
        assertEquals(MicrophoneType.CARBON, microphone.getMicrophoneType());
    }

    @Test
    public void toStringTest() throws Exception {
        assertNotNull(microphone.toString());
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Microphone.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
