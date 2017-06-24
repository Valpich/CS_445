package iit.cs445.controllers;

import iit.cs445.models.products.*;
import iit.cs445.models.services.CustomService;
import iit.cs445.models.services.SecuritySystemInstallation;
import iit.cs445.models.services.SurveillanceDesign;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class DebugController {

    private static final Random random = new Random();

    private static final Float getRandom(){
        return random.nextFloat()*100;
    }

    @RequestMapping(value = "/populate/database", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        populateProducts();
        CustomService customService = new CustomService();
        customService.setPrice(new Float(32.2));
        customService.setDescription("Custom service test");
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

        SecuritySystemInstallation securitySystemInstallation = new SecuritySystemInstallation();
        securitySystemInstallation.setPrice(getRandom());
        securitySystemInstallation.setDescription("Security system installation test");

        SurveillanceDesign surveillanceDesign = new SurveillanceDesign();
        surveillanceDesign.setPrice(getRandom());
        surveillanceDesign.setDescription("Surveillance design test");
    }
}
