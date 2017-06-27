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

@RunWith(Arquillian.class)
public class RepairableTest {

    private RepairableImplementationTest repairableImplementationTest;
    private RepairableImplementationTestTwo repairableImplementationTestTwo;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Repairable.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Before
    public void setUp() throws Exception {
        repairableImplementationTest = new RepairableImplementationTest();
        repairableImplementationTestTwo = new RepairableImplementationTestTwo();
    }

    @After
    public void tearDown() throws Exception {
        repairableImplementationTest = null;
        repairableImplementationTestTwo = null;
    }

    @Test
    public void repairPrice() throws Exception {
        assertEquals(new Float(0F), repairableImplementationTest.repairPrice());
    }

    @Test
    public void repairEquipments() throws Exception {
        assertEquals(null, repairableImplementationTest.repairEquipments());
        List<Equipment> equipments = new ArrayList<>();
        equipments.add(Equipment.AMMETER);
        repairableImplementationTest.setEquipments(equipments);
        assertEquals(equipments, repairableImplementationTest.repairEquipments());
        assertEquals(new ArrayList<>(), repairableImplementationTestTwo.repairEquipments());

    }

    private class RepairableImplementationTest implements Repairable {
        private List<Equipment> equipments;

        @Override
        public List<Equipment> repairEquipments() {
            return equipments;
        }

        public List<Equipment> getEquipments() {
            return equipments;
        }

        public void setEquipments(List<Equipment> equipments) {
            this.equipments = equipments;
        }
    }

    private class RepairableImplementationTestTwo implements Repairable {
    }

}
