package pl.marek.repository;

import pl.marek.config.MySQL;
import pl.marek.model.Order;
import pl.marek.model.OrderEntry;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderRepository implements IOrderRepository {

    private final static String CREATE_ORDER = "INSERT INTO `order` (id, order_date, user_id) VALUES (?,?,?)";
    private final static String CREATE_ORDER_ENTRY = "INSERT INTO order_entry (id, dish_name, order_id, price, amount) VALUES (?, ?, ?, ?, ?)";
    private final static String SELECT_ALL_ORDERS_ENTRY_FOR_ORDER = "SELECT * FROM order_entry WHERE order_id=?";
    private final static String SELECT_ALL_ORDERS_FOR_USER = "SELECT * FROM `order` WHERE user_id=?";
    private final static String DELETE_ORDER = "DELETE FROM `order` WHERE id=?";
    private final static String DELETE_ORDERS_FOR_USER = "DELETE FROM `order` WHERE user_id=?";
    private final static String DELETE_ORDER_ENTRIES_FOR_ORDER = "DELETE FROM order_entry WHERE order_id=?";
    private final static String SELECT_ALL_ORDERS = "SELECT * FROM `order`";

    @Override
    public List<Order> selectAllOrders() {
        List<Order> orders = new ArrayList<>();

        try {
            ResultSet resultSet = MySQL.getConnection().prepareStatement(SELECT_ALL_ORDERS).executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                Date orderDate = resultSet.getTimestamp("order_date");
                String userId = resultSet.getString("user_id");

                Order order = new Order(id, orderDate, userId);
                orders.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orders;
    }

    @Override
    public List<OrderEntry> selectAllEntriesForOrder(String orderId) {
        List<OrderEntry> orderEntries = new ArrayList<>();

        try {
            PreparedStatement statement = MySQL.getConnection().prepareStatement(SELECT_ALL_ORDERS_ENTRY_FOR_ORDER);
            statement.setString(1, orderId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String dishName = resultSet.getString("dish_name");
                double price = resultSet.getDouble("price");
                int amount = resultSet.getInt("price");
                String order_id = resultSet.getString("order_id");

                OrderEntry orderEntry = new OrderEntry(id, dishName, order_id, price, amount);
                orderEntries.add(orderEntry);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderEntries;
    }

    @Override
    public List<Order> selectAllEntriesForUser(String userId) {
        List<Order> orders = new ArrayList<>();

        try {
            PreparedStatement statement = MySQL.getConnection().prepareStatement(SELECT_ALL_ORDERS_FOR_USER);
            statement.setString(1, userId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                Date orderDate = resultSet.getTimestamp("order_date");
                String user_id = resultSet.getString("user_id");

                Order order = new Order(id, orderDate, user_id);
                orders.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orders;
    }

    @Override
    public int createOrder(Order order) {
        try {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement(CREATE_ORDER);

            preparedStatement.setString(1, order.getId());
            preparedStatement.setTimestamp(2, new Timestamp(order.getOrderDate().getTime()));
            preparedStatement.setString(3, order.getUserId());

            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int createOrderEntry(OrderEntry orderEntry) {
        try {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement(CREATE_ORDER_ENTRY);

            preparedStatement.setString(1, orderEntry.getId());
            preparedStatement.setString(2, orderEntry.getDishName());
            preparedStatement.setString(3, orderEntry.getOrderId());
            preparedStatement.setDouble(4, orderEntry.getPrice());
            preparedStatement.setInt(5, orderEntry.getAmount());

            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int deleteOrder(String id) {
        try {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement(DELETE_ORDER);

            preparedStatement.setString(1, id);

            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int deleteOrdersForUser(String userId) {
        try {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement(DELETE_ORDERS_FOR_USER);

            preparedStatement.setString(1, userId);

            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int deleteOrderEntriesForOrder(String orderId) {
        try {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement(DELETE_ORDER_ENTRIES_FOR_ORDER);

            preparedStatement.setString(1, orderId);

            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
