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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Arquillian.class)
public class DVRTest {

    private DVRClassTest dvrClassTest;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(DVR.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Before
    public void setUp() throws Exception {
        dvrClassTest = new DVRClassTest();
    }

    @After
    public void tearDown() throws Exception {
        dvrClassTest = null;
    }

    @Test
    public void getStorageTypes() throws Exception {
        List<StorageType> storageTypeList = new ArrayList<>();
        storageTypeList.add(StorageType.OTHER);
        dvrClassTest.setStorageTypes(storageTypeList);
        assertEquals(storageTypeList, dvrClassTest.getStorageTypes());
    }

    @Test
    public void setStorageTypes() throws Exception {
        List<StorageType> storageTypeList = new ArrayList<>();
        storageTypeList.add(StorageType.OTHER);
        dvrClassTest.setStorageTypes(storageTypeList);
        assertEquals(storageTypeList, dvrClassTest.getStorageTypes());
        List<StorageType> storageTypeListTwo = new ArrayList<>();
        storageTypeListTwo.add(StorageType.USB);
        dvrClassTest.setStorageTypes(storageTypeListTwo);
        assertEquals(storageTypeListTwo, dvrClassTest.getStorageTypes());
    }

    @Test
    public void toStringTest() throws Exception {
        assertNotNull(dvrClassTest.toString());
    }

    private class DVRClassTest extends DVR<DVRClassTest> {
    }

}
