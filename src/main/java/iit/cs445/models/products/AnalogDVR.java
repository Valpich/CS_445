package iit.cs445.models.products;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "analog_dvr")
public class AnalogDVR extends DVR<AnalogDVR> {

    @Column(name = "description")
    private String description;

    @Column(name = "record_format")
    @Enumerated
    @ElementCollection(targetClass = AnalogRecordFormat.class)
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    private List<AnalogRecordFormat> analogRecordFormats;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AnalogRecordFormat> getAnalogRecordFormats() {
        return analogRecordFormats;
    }

    public void setAnalogRecordFormats(List<AnalogRecordFormat> analogRecordFormats) {
        this.analogRecordFormats = analogRecordFormats;
    }

    @Override
    public String toString() {
        return "AnalogDVR{" +
                "description='" + description + '\'' +
                ", analogRecordFormats=" + analogRecordFormats +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnalogDVR analogDVR = (AnalogDVR) o;

        if (description != null ? !description.equals(analogDVR.description) : analogDVR.description != null)
            return false;
        return analogRecordFormats != null ? analogRecordFormats.equals(analogDVR.analogRecordFormats) : analogDVR.analogRecordFormats == null;
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (analogRecordFormats != null ? analogRecordFormats.hashCode() : 0);
        return result;
    }

}
