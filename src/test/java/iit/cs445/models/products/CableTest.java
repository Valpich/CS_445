package iit.cs445.models.products;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by valentinpichavant on 6/26/17.
 */
@RunWith(Arquillian.class)
public class CableTest {
    @Test
    public void getLength() throws Exception {
    }

    @Test
    public void setLength() throws Exception {
    }

    @Test
    public void toString() throws Exception {
    }

    @Test
    public void equals() throws Exception {
    }

    @Test
    public void hashCode() throws Exception {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Cable.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
