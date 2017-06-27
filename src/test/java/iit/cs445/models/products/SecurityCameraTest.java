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
public class SecurityCameraTest {

    private class SecurityCameraClassTest extends  SecurityCamera<SecurityCameraClassTest>{}
    private SecurityCameraClassTest securityCameraClassTest;

    @Before
    public void setUp() throws Exception {
        securityCameraClassTest = new SecurityCameraClassTest();
    }

    @After
    public void tearDown() throws Exception {
        securityCameraClassTest = null;
    }

    @Test
    public void getResolution() throws Exception {
        securityCameraClassTest.setResolution("1080p");
        assertEquals("1080p", securityCameraClassTest.getResolution());
    }

    @Test
    public void setResolution() throws Exception {
        securityCameraClassTest.setResolution("1080p");
        assertEquals("1080p", securityCameraClassTest.getResolution());
        securityCameraClassTest.setResolution("4K");
        assertEquals("4K", securityCameraClassTest.getResolution());
    }

    @Test
    public void toStringTest() throws Exception {
        assertNotNull(securityCameraClassTest.toString());
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(SecurityCamera.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
