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

import static org.junit.Assert.assertNotNull;

@RunWith(Arquillian.class)
public class SecuritySystemInstallationTest {

    private SecuritySystemInstallation securitySystemInstallation;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(SecuritySystemInstallation.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Before
    public void setUp() throws Exception {
        securitySystemInstallation = new SecuritySystemInstallation();
    }

    @After
    public void tearDown() throws Exception {
        securitySystemInstallation = null;
    }

    @Test
    public void toStringTest() throws Exception {
        assertNotNull(securitySystemInstallation.toString());
    }

}
