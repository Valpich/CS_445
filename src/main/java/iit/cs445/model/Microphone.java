package iit.cs445.model;


import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;

@Entity
@Table(name = "microphone")
public class Microphone extends Accessory<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "battery")
    private Boolean battery;

    @Column(name = "microphone_type")
    private MicrophoneType microphoneType;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
