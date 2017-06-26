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
}
