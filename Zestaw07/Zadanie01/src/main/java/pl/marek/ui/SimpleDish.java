package pl.marek.ui;

public class SimpleDish {

    private String id;
    private String name;
    private String price;
    private String maxOrders;
    private String vegan;

    public SimpleDish(String id, String name, String price, String maxOrders, String vegan) {
        this.id = id;
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

    public String getPrice() {
        return price;
    }

    public String getMaxOrders() {
        return maxOrders;
    }

    public String getVegan() {
        return vegan;
    }
}
