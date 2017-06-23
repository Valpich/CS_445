package iit.cs445.models.products;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "analog_dvr")
public class AnalogDVR extends DVR<AnalogDVR> {

    @Column(name = "record_format")
    @Enumerated
    @ElementCollection(targetClass = AnalogRecordFormat.class)
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    private List<AnalogRecordFormat> analogRecordFormats;

    public List<AnalogRecordFormat> getAnalogRecordFormats() {
        return analogRecordFormats;
    }

    public void setAnalogRecordFormats(List<AnalogRecordFormat> analogRecordFormats) {
        this.analogRecordFormats = analogRecordFormats;
    }

    @Override
    public String toString() {
        return "AnalogDVR{" +
                "analogRecordFormats=" + analogRecordFormats +
                "} " + super.toString();
    }

}
