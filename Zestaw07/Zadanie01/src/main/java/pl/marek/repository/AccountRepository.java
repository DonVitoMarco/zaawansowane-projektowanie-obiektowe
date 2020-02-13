package pl.marek.repository;

import pl.marek.config.MySQL;
import pl.marek.model.Address;
import pl.marek.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountRepository implements IAccountRepository {

    private static final String SELECT_ALL_USERS = "SELECT * FROM user";
    private static final String SELECT_USER = "SELECT * FROM user WHERE id=?";
    private static final String SELECT_ADDRESS_FOR_USER = "SELECT * FROM address WHERE user_id = ?";
    private static final String UPDATE_USER_PASSWORD = "UPDATE user SET password=? WHERE id=?";
    private static final String DELETE_USER = "DELETE FROM user WHERE id=?";
    private static final String DELETE_ADDRESS_FOR_USER = "DELETE FROM address WHERE user_id=?";
    private static final String CREATE_USER = "INSERT INTO user (id, login, first_name, second_name, password, email, register_date, phone) VALUES (?,?,?,?,?,?,?,?)";
    private static final String CREATE_ADDRESS = "INSERT INTO address (id, city, street, house_number, post_code, user_id) VALUES (?,?,?,?,?,?)";
    private static final String UPDATE_ADDRESS = "UPDATE address SET city=?, street=?, house_number=?, post_code=? WHERE id=?";

    @Override
    public User selectUser(String userId) {
        List<User> users = new ArrayList<>();

        try {
            PreparedStatement statement = MySQL.getConnection().prepareStatement(SELECT_USER);
            statement.setString(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String login = resultSet.getString("login");
                String firstName = resultSet.getString("first_name");
                String secondName = resultSet.getString("second_name");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                Timestamp registerDate = resultSet.getTimestamp("register_date");
                String phone = resultSet.getString("phone");

                User user = new User(id, login, firstName, secondName, password, email, phone, new Date(registerDate.getTime()));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();

        try {
            ResultSet resultSet = MySQL.getConnection().prepareStatement(SELECT_ALL_USERS).executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String login = resultSet.getString("login");
                String firstName = resultSet.getString("first_name");
                String secondName = resultSet.getString("second_name");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                Timestamp registerDate = resultSet.getTimestamp("register_date");
                String phone = resultSet.getString("phone");

                User user = new User(id, login, firstName, secondName, password, email, phone, new Date(registerDate.getTime()));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public Address selectAddress(String userId) {
        List<Address> addresses = new ArrayList<>();

        try {
            PreparedStatement statement = MySQL.getConnection().prepareStatement(SELECT_ADDRESS_FOR_USER);
            statement.setString(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String city = resultSet.getString("city");
                String street = resultSet.getString("street");
                String houseNumber = resultSet.getString("house_number");
                String postCode = resultSet.getString("post_code");
                String user = resultSet.getString("user_id");

                Address address = new Address(id, city, street, houseNumber, postCode, user);
                addresses.add(address);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return addresses.size() > 0 ? addresses.get(0) : null;
    }

    @Override
    public int changePassword(String id, String newPassword) {
        try {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement(UPDATE_USER_PASSWORD);

            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, id);

            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int deleteAddressForUser(String userId) {
        try {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement(DELETE_ADDRESS_FOR_USER);

            preparedStatement.setString(1, userId);

            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int changeAddress(String id, Address address) {
        try {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement(UPDATE_ADDRESS);

            preparedStatement.setString(1, address.getCity());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setString(3, address.getHouseNumber());
            preparedStatement.setString(4, address.getPostCode());
            preparedStatement.setString(5, id);

            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int deleteUser(String id) {
        try {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement(DELETE_USER);

            preparedStatement.setString(1, id);

            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int createUser(User user) {
        try {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement(CREATE_USER);

            preparedStatement.setString(1, user.getId());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getSecondName());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setTimestamp(7, new Timestamp(user.getRegisterDate().getTime()));
            preparedStatement.setString(8, user.getPhone());

            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int createAddress(Address address) {
        try {
            PreparedStatement preparedStatement = MySQL.getConnection().prepareStatement(CREATE_ADDRESS);

            preparedStatement.setString(1, address.getId());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setString(4, address.getPostCode());
            preparedStatement.setString(5, address.getHouseNumber());
            preparedStatement.setString(6, address.getUserId());

            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
