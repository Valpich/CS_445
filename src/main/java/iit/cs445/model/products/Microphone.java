package iit.cs445.model.products;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "microphone")
public class Microphone extends Accessory implements Installable, Repairable {

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
}
