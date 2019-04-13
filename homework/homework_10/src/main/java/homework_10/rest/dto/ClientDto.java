package homework_10.rest.dto;

import homework_10.domain.customer.Client;
import homework_10.domain.customer.Person;
import homework_10.domain.manufacture.Pizza;

import java.time.LocalDate;

public class ClientDto {

    private long id;
    private Person person;
    private String address;
    private String phone;
    private String email;
    private int ordersAmount;
    private LocalDate registryDate;
    private String comment;

    public ClientDto() {}

    public ClientDto(long id, String address, String phone, String email, String comment) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.comment = comment;
    }

    public ClientDto(long id, Person person, String address, String phone, String email, int ordersAmount, LocalDate registryDate, String comment) {
        this.id = id;
        this.person = person;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.ordersAmount = ordersAmount;
        this.registryDate = registryDate;
        this.comment = comment;
    }

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

    public static ClientDto toDto(Client client) {
        return new ClientDto(client.getId()
                , client.getPerson()
                , client.getAddress()
                , client.getPhone()
                , client.getEmail()
                , client.getOrdersAmount()
                , client.getRegistryDate()
                , client.getComment());
    }
}
