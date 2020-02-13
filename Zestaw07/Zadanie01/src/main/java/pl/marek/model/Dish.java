package pl.marek.model;

import pl.marek.config.IdGenerator;

public class Dish {

    String id;
    String name;
    double price;
    int maxOrders;
    boolean vegan;

    public Dish(String id, String name, double price, int maxOrders, boolean vegan) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.maxOrders = maxOrders;
        this.vegan = vegan;
    }

    public Dish(String name, double price, int maxOrders, boolean vegan) {
        this.id = IdGenerator.generateId();
        this.name = name;
        this.price = price;
        this.maxOrders = maxOrders;
        this.vegan = vegan;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getMaxOrders() {
        return maxOrders;
    }

    public boolean isVegan() {
        return vegan;
    }
}
