package iit.cs445.models.services;

import javax.persistence.*;

@Entity
@Table(name = "other_service")
public class CustomService extends Service<CustomService> {

    @Override
    public String toString() {
        return "CustomService{} " + super.toString();
    }
}
