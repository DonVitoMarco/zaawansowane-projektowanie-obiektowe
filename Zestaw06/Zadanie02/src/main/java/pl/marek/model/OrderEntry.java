package pl.marek.model;

import pl.marek.config.IdGenerator;

public class OrderEntry {

    private String id;
    private String dishName;
    private String orderId;
    private double price;
    private int amount;

    public OrderEntry(String id, String dishName, String orderId, double price, int amount) {
        this.id = id;
        this.dishName = dishName;
        this.orderId = orderId;
        this.price = price;
        this.amount = amount;
    }

    public OrderEntry(String dishName, String orderId, double price, int amount) {
        this.id = IdGenerator.generateId();
        this.dishName = dishName;
        this.orderId = orderId;
        this.price = price;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public String getDishName() {
        return dishName;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
}
