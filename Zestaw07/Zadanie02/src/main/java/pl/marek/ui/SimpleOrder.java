package pl.marek.ui;

public class SimpleOrder {

    private String id;
    private String orderEntryId;
    private String dishName;
    private String amount;
    private String price;
    private String totalCost;
    private String username;

    public SimpleOrder(String id, String orderEntryId, String dishName, String amount, String price, String username, String totalCost) {
        this.id = id;
        this.orderEntryId = orderEntryId;
        this.dishName = dishName;
        this.amount = amount;
        this.price = price;
        this.username = username;
        this.totalCost = totalCost;
    }

    public String getId() {
        return id;
    }

    public String getAmount() {
        return amount;
    }

    public String getOrderEntryId() {
        return orderEntryId;
    }

    public String getDishName() {
        return dishName;
    }

    public String getPrice() {
        return price;
    }

    public String getUsername() {
        return username;
    }

    public String getTotalCost() {
        return totalCost;
    }
}
