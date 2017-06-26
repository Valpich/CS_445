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

/**
 * Created by valentinpichavant on 6/26/17.
 */
@RunWith(Arquillian.class)
public class LensTest {
    @Test
    public void getFocal1() throws Exception {
    }

    @Test
    public void setFocal1() throws Exception {
    }

    @Test
    public void getMagnification1() throws Exception {
    }

    @Test
    public void setMagnification1() throws Exception {
    }

    @Test
    public void toString1() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getFocal() throws Exception {
    }

    @Test
    public void setFocal() throws Exception {
    }

    @Test
    public void getMagnification() throws Exception {
    }

    @Test
    public void setMagnification() throws Exception {
    }

    @Test
    public void toString() throws Exception {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Lens.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
