package pl.marek.model;

import pl.marek.config.IdGenerator;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class User {

    private String id;
    private String login;
    private String firstName;
    private String secondName;
    private String password;
    private String email;
    private String phone;
    private Date registerDate;

    public User(String id, String login, String firstName, String secondName, String password, String email, String phone, Date registerDate) {
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.secondName = secondName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.registerDate = registerDate;
    }

    public User(String login, String firstName, String secondName, String password, String email, String phone) {
        this.id = IdGenerator.generateId();
        this.login = login;
        this.firstName = firstName;
        this.secondName = secondName;
        this.password = password;
        this.email = email;
        this.registerDate = Timestamp.valueOf(LocalDateTime.now());
        this.phone = phone;
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

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Date getRegisterDate() {
        return registerDate;
    }
}
