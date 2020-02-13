package pl.marek.repository;

import pl.marek.config.MySQL;
import pl.marek.model.Dish;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DishRepository implements IDishRepository {

    private final static String CREATE_DISH = "INSERT INTO dish (id, name, price, max_orders, vegan) VALUES (?,?,?,?,?)";
    private final static String DELETE_DISH = "DELETE FROM dish WHERE id=?";
    private final static String UPDATE_DISH = "UPDATE dish SET name=?, price=?, max_orders=?, vegan=? WHERE id=?";
    private final static String SELECT_ALL_DISH = "SELECT * FROM dish";
    private final static String SELECT_DISH = "SELECT * FROM dish WHERE id=?";

    public Dish selectDish(String dishId) {
        List<Dish> dishes = new ArrayList<>();

        try {
            PreparedStatement statement = MySQL.getConnection().prepareStatement(SELECT_DISH);
            statement.setString(1, dishId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int maxOrders = resultSet.getInt("max_orders");
                boolean vegan = resultSet.getBoolean("vegan");

                Dish dish = new Dish(id, name, price, maxOrders, vegan);
                dishes.add(dish);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dishes.size() > 0 ? dishes.get(0) : null;
    }

    @Override
    public List<Dish> selectAllDishes() {
        List<Dish> dishes = new ArrayList<>();

        try {
            ResultSet resultSet = MySQL.getConnection().prepareStatement(SELECT_ALL_DISH).executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int maxOrders = resultSet.getInt("max_orders");
                boolean vegan = resultSet.getBoolean("vegan");

                Dish dish = new Dish(id, name, price, maxOrders, vegan);
                dishes.add(dish);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dishes;
    }

    @Override
    public int createDish(Dish dish) {
        try {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement(CREATE_DISH);

            preparedStatement.setString(1, dish.getId());
            preparedStatement.setString(2, dish.getName());
            preparedStatement.setDouble(3, dish.getPrice());
            preparedStatement.setInt(4, dish.getMaxOrders());
            preparedStatement.setBoolean(5, dish.isVegan());

            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int deleteDish(String id) {
        try {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement(DELETE_DISH);

            preparedStatement.setString(1, id);

            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int changeDish(Dish dish) {
        try {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement(UPDATE_DISH);

            preparedStatement.setString(1, dish.getName());
            preparedStatement.setDouble(2, dish.getPrice());
            preparedStatement.setInt(3, dish.getMaxOrders());
            preparedStatement.setBoolean(4, dish.isVegan());
            preparedStatement.setString(5, dish.getId());

            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
