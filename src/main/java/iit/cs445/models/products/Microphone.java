package iit.cs445.models.products;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "microphone")
public class Microphone extends Accessory<Microphone> implements Installable, Repairable {

    @Column(name = "battery")
    private Boolean battery;

    @Column(name = "microphone_type")
    private MicrophoneType microphoneType;

    public Boolean getBattery() {
        return battery;
    }

    public void setBattery(Boolean battery) {
        this.battery = battery;
    }

    public MicrophoneType getMicrophoneType() {
        return microphoneType;
    }

    public void setMicrophoneType(MicrophoneType microphoneType) {
        this.microphoneType = microphoneType;
    }

    @Override
    public String toString() {
        return "Microphone{" +
                "battery=" + battery +
                ", microphoneType=" + microphoneType +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Microphone that = (Microphone) o;

        if (battery != null ? !battery.equals(that.battery) : that.battery != null) return false;
        return microphoneType == that.microphoneType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (battery != null ? battery.hashCode() : 0);
        result = 31 * result + (microphoneType != null ? microphoneType.hashCode() : 0);
        return result;
    }
}
