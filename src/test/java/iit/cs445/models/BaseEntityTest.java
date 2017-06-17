package iit.cs445.models;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class BaseEntityTest {
    @Test
    public void getCreationTime() throws Exception {
    }

    @Test
    public void setCreationTime() throws Exception {
    }

    @Test
    public void getModificationTime() throws Exception {
    }

    @Test
    public void setModificationTime() throws Exception {
    }

    @Test
    public void getVersion() throws Exception {
    }

    @Test
    public void setVersion() throws Exception {
    }

    @Test
    public void prePersist() throws Exception {
    }

    @Test
    public void preUpdate() throws Exception {
    }

    @Test
    public void toStringTest() throws Exception {
    }

    @Test
    public void saveNew() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(BaseEntity.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
