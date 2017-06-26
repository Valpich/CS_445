package iit.cs445.controllers;

import iit.cs445.models.orders.OrderType;
import iit.cs445.models.products.*;
import iit.cs445.models.services.CustomService;
import iit.cs445.models.services.SecuritySystemInstallation;
import iit.cs445.models.services.SurveillanceDesign;
import iit.cs445.models.services.SurveillanceSystemRepair;
import iit.cs445.models.users.Address;
import iit.cs445.models.users.User;
import iit.cs445.models.users.Cart;
import iit.cs445.models.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class DebugController {

    @Autowired
    private UserService userService;

    private static final Random random = new Random();

    private static final Float getRandom(){
        return random.nextFloat()*100;
    }

    @RequestMapping(value = "/populate/database", method = RequestMethod.GET)
    public String populateDatabase() {
        populateProducts();
        populateServices();
        populateUsers();
        return "redirect:/";
    }

    @RequestMapping(value = "/populate/cart", method = RequestMethod.GET)
    public String populateCart(HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        if(user == null);
            user = userService.findUserByMail("antoine@regnier.com");
        if(user == null){
            populateUsers();
            request.getSession().setAttribute("user", user);
        }
        populateCart((Cart)request.getSession().getAttribute("cart"));
        return "redirect:/";
    }

    private void populateProducts() {
        populateAccessories();
        populateSurveillanceCameras();
        populateDVR();
    }

    private void populateAccessories() {
        Bracket bracket = new Bracket();
        bracket.setDescription("Bracket test");
        bracket.saveNew();

        Cable cable = new Cable();
        cable.setPrice(getRandom());
        cable.setLength(getRandom());
        cable.setDescription("Cable test");
        cable.saveNew();

        Connector connector = new Connector();
        connector.setPrice(getRandom());
        connector.setDescription("Connector test");
        connector.saveNew();

        Housing housing = new Housing();
        housing.setPrice(getRandom());
        housing.setDescription("Housing test");
        housing.saveNew();

        InfraredLightning infraredLightning = new InfraredLightning();
        infraredLightning.setPrice(getRandom());
        infraredLightning.setDescription("Infrared lighting test");
        infraredLightning.saveNew();

        Lens lens = new Lens();
        lens.setPrice(getRandom());
        lens.setFocal(getRandom());
        lens.setMagnification(getRandom());
        lens.setDescription("Lens test");
        lens.saveNew();

        Microphone microphone = new Microphone();
        microphone.setBattery(true);
        microphone.setMicrophoneType(MicrophoneType.CONDENSER);
        microphone.setPrice(getRandom());
        microphone.setDescription("Condenser microphone test");
        microphone.saveNew();

        Monitor monitor = new Monitor();
        monitor.setMaxResolution("1080p");
        monitor.setSize(getRandom()*2);
        monitor.setPrice(getRandom());
        monitor.setDescription("Monitor test");
        monitor.saveNew();

        PowerSupply powerSupply = new PowerSupply();
        powerSupply.setMaximum_output("500W");
        powerSupply.setVoltage(110F);
        powerSupply.setPrice(getRandom());
        powerSupply.setDescription("Power supply test");
        powerSupply.saveNew();
    }

    private void populateSurveillanceCameras(){
        AnalogSurveillanceCamera analogSurveillanceCamera = new AnalogSurveillanceCamera();
        analogSurveillanceCamera.setPrice(getRandom());
        analogSurveillanceCamera.setResolution("720p");
        analogSurveillanceCamera.setDescription("Analog surveillance camera test");
        analogSurveillanceCamera.saveNew();

        DigitalSurveillanceCamera digitalSurveillanceCamera = new DigitalSurveillanceCamera();
        digitalSurveillanceCamera.setPrice(getRandom());
        digitalSurveillanceCamera.setDescription("Digital surveillance camera test");
        digitalSurveillanceCamera.setResolution("4K");
        digitalSurveillanceCamera.saveNew();

        IPSurveillanceCamera ipSurveillanceCamera = new IPSurveillanceCamera();
        ipSurveillanceCamera.setDescription("IP surveillance camera test");
        ipSurveillanceCamera.setPrice(getRandom());
        ipSurveillanceCamera.setResolution("1080p");
        ipSurveillanceCamera.saveNew();
    }

    private void populateDVR(){
        AnalogDVR analogDVR = new AnalogDVR();
        List<AnalogRecordFormat> analogRecordFormats = new ArrayList<>();
        analogRecordFormats.add(AnalogRecordFormat.NTSC);
        analogDVR.setAnalogRecordFormats(analogRecordFormats);
        analogDVR.setPrice(getRandom());
        List<StorageType> storageTypes = new ArrayList<>();
        storageTypes.add(StorageType.SD_MEMORY_CARD);
        analogDVR.setStorageTypes(storageTypes);
        analogDVR.setDescription("Analog DVR test");
        analogDVR.saveNew();

        DigitalDVR digitalDVR = new DigitalDVR();
        digitalDVR.setPrice(getRandom());
        List<StorageType> storageTypesTwo = new ArrayList<>();
        storageTypesTwo.add(StorageType.SSD);
        storageTypesTwo.add(StorageType.DISK_DRIVE);
        digitalDVR.setStorageTypes(storageTypesTwo);
        digitalDVR.setDescription("Digital DVR test");
        digitalDVR.saveNew();

        HybridDVR hybridDVR = new HybridDVR();
        hybridDVR.setPrice(getRandom());
        List<StorageType> storageTypesThree = new ArrayList<>();
        storageTypesThree.add(StorageType.SSD);
        storageTypesThree.add(StorageType.USB);
        storageTypesThree.add(StorageType.OTHER);
        hybridDVR.setStorageTypes(storageTypesThree);
        hybridDVR.setDescription("Digital DVR test");
        hybridDVR.saveNew();
    }

    private void populateServices(){
        CustomService customService = new CustomService();
        customService.setDescription("Custom service test");
        customService.setPrice(getRandom());
        customService.saveNew();

        SecuritySystemInstallation securitySystemInstallation = new SecuritySystemInstallation();
        securitySystemInstallation.setPrice(getRandom());
        securitySystemInstallation.setDescription("Security system installation test");
        securitySystemInstallation.saveNew();

        SurveillanceDesign surveillanceDesign = new SurveillanceDesign();
        surveillanceDesign.setPrice(getRandom());
        surveillanceDesign.setDescription("Surveillance design test");
        surveillanceDesign.saveNew();

        SurveillanceSystemRepair surveillanceSystemRepair = new SurveillanceSystemRepair();
        surveillanceSystemRepair.setPrice(getRandom());
        surveillanceSystemRepair.setDescription("Surveillance system repair test");
        surveillanceSystemRepair.saveNew();
    }

    private void populateUsers(){
        User user = new User();
        user.setFirstName("Antoine");
        user.setLastName("Regnier");
        user.setEmail("antoine@regnier.com");
        user.setPassword("qaws1234");
        List<Address> addresses = new ArrayList<>();
        Address address = new Address();
        address.setCity("Chicago");
        address.setCountry("USA");
        address.setFirstName("Antoine");
        address.setLastName("Regnier");
        address.setPhoneNumber("(123) 456 - 7890");
        address.setState("Illinois");
        address.setZipCode("60614");
        address.setStreetAddress("1234, Fullerton Ave");
        addresses.add(address);
        user.setAddresses(addresses);
        user.saveNew();
    }

    private void populateCart(Cart cart){
        Cable cable = new Cable();
        cable.setPrice(getRandom());
        cable.setLength(getRandom());
        cable.setDescription("Cable cart test");
        cable.saveNew();
        cable.setOrderType(OrderType.BUY);
        cart.add(cable);
        CustomService customService = new CustomService();
        customService.setDescription("Custom service cart test");
        customService.setPrice(getRandom());
        customService.saveNew();
        cart.add(customService);
    }

}
