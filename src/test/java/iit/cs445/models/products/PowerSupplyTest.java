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
public class PowerSupplyTest {

    private PowerSupply powerSupply;

    @Before
    public void setUp() throws Exception {
        powerSupply = new PowerSupply();
    }

    @After
    public void tearDown() throws Exception {
        powerSupply = null;
    }

    @Test
    public void getMaximumOutput() throws Exception {
        powerSupply.setMaximumOutput("220V");
        assertEquals("220V", powerSupply.getMaximumOutput());
    }

    @Test
    public void setMaximumOutput() throws Exception {
        powerSupply.setMaximumOutput("500W");
        assertEquals("500W", powerSupply.getMaximumOutput());
        powerSupply.setMaximumOutput("1000W");
        assertEquals("1000W", powerSupply.getMaximumOutput());
    }

    @Test
    public void getVoltage() throws Exception {
        Float voltage = 220F;
        powerSupply.setVoltage(voltage);
        assertEquals(voltage, powerSupply.getVoltage());
    }

    @Test
    public void setVoltage() throws Exception {
        Float voltage = 220F;
        powerSupply.setVoltage(voltage);
        assertEquals(voltage, powerSupply.getVoltage());
        Float voltageTwo = 110F;
        powerSupply.setVoltage(voltageTwo);
        assertEquals(voltageTwo, powerSupply.getVoltage());
    }

    @Test
    public void toStringTest() throws Exception {
        assertNotNull(powerSupply.toString());
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(PowerSupply.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
