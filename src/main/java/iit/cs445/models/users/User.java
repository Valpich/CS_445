package iit.cs445.models.users;

import iit.cs445.models.BaseEntity;
import iit.cs445.models.orders.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Entity
@Table(name = "user_account")
public class User extends BaseEntity<Long, User> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @Column(name = "password")
    private String password;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_address", joinColumns = {
            @JoinColumn(name = "user_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "address_id",
                    nullable = false, updatable = false)})
    private List<Address> addresses;

    @Transient
    private List<Order> orders;

    public User(){
        addresses = new ArrayList<>();
        orders = new ArrayList<>();
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> address) {
        this.addresses = address;
    }

    public List<Order> getOrders() {
        orders = new ArrayList<>();
        for (Order o : new Order().listAll()) {
            if (o.getUser().getId().equals(this.getId()))
                orders.add(o);
        }
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public void update() {
        Session session = localSessionFactoryBean.getObject().openSession();
        Logger.getLogger(getClass().getName()).log(Level.INFO, "User update call");
        try {
            Transaction tx = session.beginTransaction();
            for (Address address : addresses) {
                session.evict(address);
            }
            session.update(this);
            tx.commit();
        } catch(OptimisticLockException ole){
                Logger.getLogger(getClass().getName()).log(Level.WARNING, "OLE caught "+ole.toString());
                session.close();
                try {
                    session = localSessionFactoryBean.getObject().openSession();
                    Transaction tx = session.beginTransaction();
                    session.merge(this);
                    tx.commit();
                }catch (Exception exc) {
                    Logger.getLogger(getClass().getName()).log(Level.WARNING, exc.toString());
                } finally {
                    session.close();
                }
        } catch (Exception exc) {
            Logger.getLogger(getClass().getName()).log(Level.WARNING, exc.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", address=" + addresses +
                "} " + super.toString();
    }

}