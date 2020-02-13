package pl.marek.ui;

public class SimpleUser {

    private String id;
    private String login;
    private String firstName;
    private String secondName;
    private String email;
    private String phone;
    private String address;

    public SimpleUser(String id, String login, String firstName, String secondName, String email, String phone, String address) {
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
