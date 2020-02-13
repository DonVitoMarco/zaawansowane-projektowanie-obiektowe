package pl.marek.model;

import pl.marek.config.IdGenerator;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class Order {

    private String id;
    private Date orderDate;
    private String userId;

    public Order(String id, Date orderDate, String userId) {
        this.id = id;
        this.orderDate = orderDate;
        this.userId = userId;
    }

    public Order(String userId) {
        this.id = IdGenerator.generateId();
        this.orderDate = Timestamp.valueOf(LocalDateTime.now());
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getUserId() {
        return userId;
    }
}
