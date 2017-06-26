package iit.cs445.models.users;

import iit.cs445.models.BaseEntity;
import iit.cs445.models.orders.Order;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class OrderAddress extends BaseEntity<Long, OrderAddress> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Long id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "order_address", joinColumns = {
            @JoinColumn(name = "address_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "order_id",
                    nullable = false, updatable = false) })
    private Order order;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderAddress clone(Address address) {
        OrderAddress orderAddress = new OrderAddress();
        orderAddress.setPhoneNumber(address.getPhoneNumber());
        orderAddress.setStreetAddress(address.getStreetAddress());
        orderAddress.setFirstName(address.getFirstName());
        orderAddress.setLastName(address.getLastName());
        orderAddress.setZipCode(address.getZipCode());
        orderAddress.setCountry(address.getCountry());
        orderAddress.setCity(address.getCity());
        orderAddress.setState(address.getState());
        return orderAddress;
    }

    @Override
    public String toString() {
        return "OrderAddress{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                "} " + super.toString();
    }


}
