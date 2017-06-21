package iit.cs445.models.products;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "microphone")
public class Microphone extends Accessory<Microphone> implements Installable, Repairable {

    @Column(name = "description")
    private String description;

    @Column(name = "battery")
    private Boolean battery;

    @Column(name = "microphone_type")
    private MicrophoneType microphoneType;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Microphone{" +
                "description='" + description + '\'' +
                ", battery=" + battery +
                ", microphoneType=" + microphoneType +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Microphone that = (Microphone) o;

        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (battery != null ? !battery.equals(that.battery) : that.battery != null) return false;
        return microphoneType == that.microphoneType;
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (battery != null ? battery.hashCode() : 0);
        result = 31 * result + (microphoneType != null ? microphoneType.hashCode() : 0);
        return result;
    }

}
