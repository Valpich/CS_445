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

@RunWith(Arquillian.class)
public class InstallableTest {

    private InstallableImplementationTest installableImplementationTest;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Installable.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

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
        assertEquals(new Float(0F), installableImplementationTest.installPrice());
    }

    @Test
    public void installEquipments() throws Exception {
        assertEquals(0, installableImplementationTest.installEquipments().size());
    }

    private class InstallableImplementationTest implements Installable {
    }

}
