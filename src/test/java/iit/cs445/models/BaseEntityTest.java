package iit.cs445.models;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class BaseEntityTest {

    private class BaseEntityClassTest extends BaseEntity<Long, BaseEntityClassTest>{

        @Override
        public Long getId() {
            return null;
        }
    }
    private BaseEntityClassTest baseEntityClassTest;

    @Before
    public void setUp() throws Exception {
        baseEntityClassTest = new BaseEntityClassTest();
    }

    @After
    public void tearDown() throws Exception {
        baseEntityClassTest = null;
    }

    @Test
    public void getId() throws Exception {
        assertNull(baseEntityClassTest.getId());
    }

    @Test
    public void getCreationTime() throws Exception {
        Date date = new Date();
        baseEntityClassTest.setCreationTime(date);
        assertEquals(date, baseEntityClassTest.getCreationTime());
    }

    @Test
    public void setCreationTime() throws Exception {
        Date date = new Date();
        baseEntityClassTest.setCreationTime(date);
        assertEquals(date, baseEntityClassTest.getCreationTime());
        Date dateTwo = new Date();
        baseEntityClassTest.setCreationTime(dateTwo);
        assertEquals(dateTwo, baseEntityClassTest.getCreationTime());
    }

    @Test
    public void getModificationTime() throws Exception {
        Date date = new Date();
        baseEntityClassTest.setModificationTime(date);
        assertEquals(date, baseEntityClassTest.getModificationTime());
    }

    @Test
    public void setModificationTime() throws Exception {
        Date date = new Date();
        baseEntityClassTest.setModificationTime(date);
        assertEquals(date, baseEntityClassTest.getModificationTime());
        Date dateTwo = new Date();
        baseEntityClassTest.setModificationTime(dateTwo);
        assertEquals(dateTwo, baseEntityClassTest.getModificationTime());
    }

    @Test
    public void getVersion() throws Exception {
        assertEquals(0, baseEntityClassTest.getVersion());
    }

    @Test
    public void setVersion() throws Exception {
        assertEquals(0, baseEntityClassTest.getVersion());
        baseEntityClassTest.setVersion(1);
        assertEquals(1, baseEntityClassTest.getVersion());
    }

    @Test
    public void toStringTest() throws Exception {
        assertNotNull(baseEntityClassTest.toString());
    }

    @Test
    public void saveNew() throws Exception {
        boolean exception = false;
        try{
            baseEntityClassTest.saveNew();
        }catch (NullPointerException npe){
            exception = true;
        }
        assertEquals(true, exception);
    }

    @Test
    public void update() throws Exception {
        boolean exception = false;
        try{
            baseEntityClassTest.update();
        }catch (NullPointerException npe){
            exception = true;
        }
        assertEquals(true, exception);
    }

    @Test
    public void delete() throws Exception {
        boolean exception = false;
        try{
            baseEntityClassTest.delete();
        }catch (NullPointerException npe){
            exception = true;
        }
        assertEquals(true, exception);
    }

    @Test
    public void listAll() throws Exception {
        boolean exception = false;
        try{
            baseEntityClassTest.listAll();
        }catch (NullPointerException npe){
            exception = true;
        }
        assertEquals(true, exception);
    }

    @Test
    public void findById() throws Exception {
        boolean exception = false;
        try{
            baseEntityClassTest.findById(1L);
        }catch (NullPointerException npe){
            exception = true;
        }
        assertEquals(true, exception);
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(BaseEntity.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
