package iit.cs445.models.services;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "security_system_installation")
public class SecuritySystemInstallation extends Service<SecuritySystemInstallation> {

    @Override
    public String toString() {
        return "SecuritySystemInstallation{} " + super.toString();
    }

}
