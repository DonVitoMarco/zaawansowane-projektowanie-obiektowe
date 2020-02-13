package pl.marek.model;

import pl.marek.config.IdGenerator;

public class Address {

    private String id;
    private String city;
    private String street;
    private String houseNumber;
    private String postCode;
    private String userId;

    public Address(String id, String city, String street, String houseNumber, String postCode, String userId) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postCode = postCode;
        this.userId = userId;
    }

    public Address(String city, String street, String houseNumber, String postCode, String userId) {
        this.id = IdGenerator.generateId();
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postCode = postCode;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getUserId() {
        return userId;
    }
}
