package homework_9.domain.customer;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CLIENTS")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
//    @Column(name = "PERSON")
    @OneToOne
    private Person person;
    @Column(name = "DELIVERY_ADDRESSES")
    private String address;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ORDERS_AMOUNT")
    private int ordersAmount;
    @Column(name = "REGISTRY_DATE")
    private LocalDate registryDate;
    @Column(name = "COMMENT")
    private String comment;

    public Client() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getOrdersAmount() {
        return ordersAmount;
    }

    public void setOrdersAmount(int ordersAmount) {
        this.ordersAmount = ordersAmount;
    }

    public LocalDate getRegistryDate() {
        return registryDate;
    }

    public void setRegistryDate(LocalDate registryDate) {
        this.registryDate = registryDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
