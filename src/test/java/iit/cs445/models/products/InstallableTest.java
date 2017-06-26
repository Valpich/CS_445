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
public class InstallableTest {

    private class InstallableImplementationTest implements Installable{}
    private InstallableImplementationTest installableImplementationTest;

    @Before
    public void setUp() throws Exception {
        installableImplementationTest = new InstallableImplementationTest();
    }

    @After
    public void tearDown() throws Exception {
        installableImplementationTest = null;
    }

    @Test
    public void installPrice() throws Exception {
    }

    @Test
    public void installEquipments() throws Exception {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Installable.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
