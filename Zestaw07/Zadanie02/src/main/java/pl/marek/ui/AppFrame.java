package pl.marek.ui;

import pl.marek.model.*;
import pl.marek.repository.*;
import pl.marek.service.*;
import pl.marek.util.Parser;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class AppFrame extends JFrame {

    protected IAccountService accountService;
    protected IDishService dishService;
    protected IOrderService orderService;

    protected JComboBox userComboBox;
    protected JComboBox dishComboBox;
    protected JTextField amountText;

    protected JTable ordersTable;
    protected JTable usersTable;
    protected JTable dishesTable;

    protected JScrollPane dishesScrollPane;
    protected JScrollPane usersScrollPane;
    protected JScrollPane ordersScrollPane;

    protected JTextField loginText;
    protected JTextField passwordText;
    protected JTextField firstNameText;
    protected JTextField secondNameText;
    protected JTextField emailText;
    protected JTextField phoneText;
    protected JTextField cityText;
    protected JTextField streetText;
    protected JTextField houseText;
    protected JTextField postCodeText;

    protected JTextField nameText;
    protected JTextField priceText;
    protected JTextField maxOrdersText;
    protected JRadioButton radioButtonTrue;
    protected JRadioButton radioButtonFalse;

    public AppFrame() {
        IAccountRepository accountRepository = new AccountRepository();
        IDishRepository dishRepository = new DishRepository();
        IOrderRepository orderRepository = new OrderRepository();

        accountService = new AccountService(accountRepository, orderRepository);
        dishService = new DishService(dishRepository);
        orderService = new OrderService(orderRepository);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setResizable(false);
        setTitle("ZZPO");
        setSize(1200, 1020);

        createOrderCreator();
        createUserCreator();
        createDishCreator();

        createOrdersTable();
        createUsersTable();
        createDishTable();

        deleteDishButton();
        deleteOrderButton();
        deleteUserButton();

        updateDishButton();
        updateUserButton();
    }

    private List<SimpleOrder> getMappedOrders() {
        List<SimpleOrder> simpleOrders = new ArrayList<>();

        orderService.getOrders().forEach(o -> {
            orderService.getOrderEntries(o.getId()).forEach(e -> {
                User user = accountService.getUser(o.getUserId());
                String userName = user != null ? user.getLogin() : "";

                SimpleOrder simpleOrder = new SimpleOrder(o.getId(), e.getId(), e.getDishName(), Integer.toString(e.getAmount()),
                        Double.toString(e.getPrice()), userName, Double.toString(e.getAmount() * e.getPrice()));
                simpleOrders.add(simpleOrder);
            });
        });

        return simpleOrders;
    }

    private List<SimpleUser> getMappedUsers() {
        List<SimpleUser> simpleUsers = new ArrayList<>();

        accountService.getUsers().forEach(u -> {
            Address address = accountService.getAddressForUser(u.getId());

            SimpleUser simpleUser = new SimpleUser(u.getId(), u.getLogin(), u.getFirstName(), u.getSecondName(),
                    u.getEmail(), u.getPhone(), address.getCity() + " " + address.getStreet() + " " + address.getHouseNumber());
            simpleUsers.add(simpleUser);
        });

        return simpleUsers;
    }

    private List<SimpleDish> getMappedDishes() {
        List<SimpleDish> simpleDishes = new ArrayList<>();

        dishService.getDishes().forEach(d -> {
            SimpleDish simpleDish = new SimpleDish(d.getId(), d.getName(), Double.toString(d.getPrice()),
                    Integer.toString(d.getMaxOrders()), Boolean.toString(d.isVegan()));
            simpleDishes.add(simpleDish);
        });

        return simpleDishes;
    }

    private void createOrdersTable() {
        SimpleOrderTableModel simpleOrderTableModel = new SimpleOrderTableModel(getMappedOrders());
        ordersTable = new JTable(simpleOrderTableModel);
        ordersScrollPane = new JScrollPane(ordersTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        ordersScrollPane.setBounds(300, 10, 900, 250);
        add(ordersScrollPane);
    }

    private void createUsersTable() {
        SimpleUserTableModel simpleUserTableModel = new SimpleUserTableModel(getMappedUsers());
        usersTable = new JTable(simpleUserTableModel);
        usersScrollPane = new JScrollPane(usersTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        usersScrollPane.setBounds(300, 310, 900, 250);
        add(usersScrollPane);
    }

    private void createDishTable() {
        SimpleDishTableModel simpleDishTableModel = new SimpleDishTableModel(getMappedDishes());
        dishesTable = new JTable(simpleDishTableModel);
        dishesScrollPane = new JScrollPane(dishesTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        dishesScrollPane.setBounds(300, 610, 900, 250);
        add(dishesScrollPane);
    }

    private void deleteDishButton() {
        JButton delete = new JButton("DELETE SELECTED");
        delete.setBounds(950, 870, 200, 15);

        delete.addActionListener(e -> {
            String id = (String) dishesTable.getModel().getValueAt(dishesTable.getSelectedRow(), 0);
            dishService.deleteDish(id);
            updateDishesTable();
        });

        add(delete);
    }

    private void deleteOrderButton() {
        JButton delete = new JButton("DELETE SELECTED");
        delete.setBounds(950, 270, 200, 15);

        delete.addActionListener(e -> {
            Object value = ordersTable.getModel().getValueAt(ordersTable.getSelectedRow(), 0);
            if (value != null) {
                String id = (String) value;
                orderService.deleteOrder(id);
                updateOrdersTable();
            }
        });

        add(delete);
    }

    private void deleteUserButton() {
        JButton delete = new JButton("DELETE SELECTED");
        delete.setBounds(950, 570, 200, 15);

        delete.addActionListener(e -> {
            Object value = usersTable.getModel().getValueAt(usersTable.getSelectedRow(), 0);
            if (value != null) {
                String id = (String) value;
                accountService.deleteUser(id);
                updateUsersTable();
            }
        });

        add(delete);
    }

    private void updateUserButton() {
        JButton update = new JButton("UPDATE ADDRESS");
        update.setBounds(750, 570, 200, 15);
        update.addActionListener(e -> {
            Object value = usersTable.getModel().getValueAt(usersTable.getSelectedRow(), 0);
            if (value != null) {
                String id = (String) value;
                UpdateUserFrame updateUserFrame = new UpdateUserFrame(id, accountService);
                updateUserFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        updateUsersTable();
                    }
                });
            }
        });

        add(update);
    }

    private void updateDishButton() {
        JButton update = new JButton("UPDATE SELECTED");
        update.setBounds(750, 870, 200, 15);
        update.addActionListener(e -> {
            Object value = dishesTable.getModel().getValueAt(dishesTable.getSelectedRow(), 0);
            if (value != null) {
                String id = (String) value;
                UpdateDishFrame updateDishFrame = new UpdateDishFrame(id, dishService);
                updateDishFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        updateDishesTable();
                    }
                });
            }
        });

        add(update);
    }

    private void updateDishesTable() {
        dishesTable.setModel(new SimpleDishTableModel(getMappedDishes()));
        dishesTable.repaint();
    }

    private void updateUsersTable() {
        usersTable.setModel(new SimpleUserTableModel(getMappedUsers()));
        usersTable.repaint();
    }

    private void updateOrdersTable() {
        ordersTable.setModel(new SimpleOrderTableModel(getMappedOrders()));
        ordersTable.repaint();
    }

    private void createOrderCreator() {
        JLabel titleCreator = new JLabel("ORDER CREATOR");
        titleCreator.setBounds(50, 5, 200, 15);

        JLabel userLabel = new JLabel("User: ");
        userLabel.setBounds(10, 30, 200, 15);

        userComboBox = new JComboBox();
        userComboBox.setBounds(10, 55, 200, 20);
        userComboBox.setRenderer(new UserRendererComboBox());

        JLabel dishLabel = new JLabel("Dish: ");
        dishLabel.setBounds(10, 80, 200, 15);

        dishComboBox = new JComboBox();
        dishComboBox.setBounds(10, 105, 200, 20);
        dishComboBox.setRenderer(new DishRendererComboBox());

        JLabel amountLabel = new JLabel("Amount: ");
        amountLabel.setBounds(10, 130, 200, 15);

        amountText = new JTextField("");
        amountText.setBounds(10, 155, 200, 20);

        JButton save = new JButton("SAVE");
        save.setBounds(10, 180, 200, 15);

        save.addActionListener(e -> {
            createOrder();
            updateOrdersTable();
            clearTextFields();
        });

        add(titleCreator);
        add(userLabel);
        add(userComboBox);
        add(dishLabel);
        add(dishComboBox);
        add(amountLabel);
        add(amountText);
        add(save);

        updateComboBox();
    }

    private void createUserCreator() {
        JLabel titleCreator = new JLabel("USER CREATOR");
        titleCreator.setBounds(50, 195, 200, 15);

        JLabel loginLabel = new JLabel("Login: ");
        loginLabel.setBounds(10, 220, 200, 15);

        loginText = new JTextField("");
        loginText.setBounds(10, 245, 200, 20);

        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(10, 270, 200, 15);

        passwordText = new JTextField("");
        passwordText.setBounds(10, 295, 200, 20);

        JLabel firstNameLabel = new JLabel("First name: ");
        firstNameLabel.setBounds(10, 320, 200, 15);

        firstNameText = new JTextField("");
        firstNameText.setBounds(10, 345, 200, 20);

        JLabel secondNameLabel = new JLabel("Second name: ");
        secondNameLabel.setBounds(10, 370, 200, 15);

        secondNameText = new JTextField("");
        secondNameText.setBounds(10, 395, 200, 20);

        JLabel emailLabel = new JLabel("Email: ");
        emailLabel.setBounds(10, 420, 200, 15);

        emailText = new JTextField("");
        emailText.setBounds(10, 445, 200, 20);

        JLabel phoneLabel = new JLabel("Phone: ");
        phoneLabel.setBounds(10, 470, 200, 15);

        phoneText = new JTextField("");
        phoneText.setBounds(10, 495, 200, 20);

        JLabel cityLabel = new JLabel("City: ");
        cityLabel.setBounds(10, 520, 200, 15);

        cityText = new JTextField("");
        cityText.setBounds(10, 545, 200, 20);

        JLabel streetLabel = new JLabel("Street: ");
        streetLabel.setBounds(10, 570, 200, 15);

        streetText = new JTextField("");
        streetText.setBounds(10, 585, 200, 20);

        JLabel houseLabel = new JLabel("House number: ");
        houseLabel.setBounds(10, 610, 200, 15);

        houseText = new JTextField("");
        houseText.setBounds(10, 635, 200, 20);

        JLabel postCodeLabel = new JLabel("Post Code: ");
        postCodeLabel.setBounds(10, 660, 200, 15);

        postCodeText = new JTextField("");
        postCodeText.setBounds(10, 685, 200, 20);

        JButton save = new JButton("SAVE");
        save.setBounds(10, 710, 200, 15);

        save.addActionListener(e -> {
            createUser();
            updateComboBox();
            updateUsersTable();
            clearTextFields();
        });

        add(titleCreator);
        add(loginLabel);
        add(loginText);
        add(passwordLabel);
        add(passwordText);
        add(firstNameLabel);
        add(firstNameText);
        add(secondNameLabel);
        add(secondNameText);
        add(emailLabel);
        add(emailText);
        add(phoneLabel);
        add(phoneText);
        add(cityLabel);
        add(cityText);
        add(streetLabel);
        add(streetText);
        add(houseLabel);
        add(houseText);
        add(postCodeLabel);
        add(postCodeText);
        add(save);
    }

    private void createUser() {
        String login = loginText.getText();
        String firstName = firstNameText.getText();
        String secondName = secondNameText.getText();
        String password = passwordText.getText();
        String email = emailText.getText();
        String phone = phoneText.getText();
        String city = cityText.getText();
        String street = streetText.getText();
        String house = houseText.getText();
        String postCode = postCodeText.getText();

        if (!login.equals("") && !firstName.equals("") && !secondName.equals("") && !email.equals("") && !phone.equals("") &&
                !city.equals("") && !street.equals("") && !house.equals("") && !postCode.equals("") && !password.equals("")) {
            User user = new User(login, firstName, secondName, password, email, phone);
            Address address = new Address(city, street, house, postCode, user.getId());

            accountService.createUserWithAddress(user, address);
        }
    }

    private void createOrder() {
        User userItem = (User) userComboBox.getSelectedItem();
        Dish dishItem = (Dish) dishComboBox.getSelectedItem();
        String amountText = this.amountText.getText();

        boolean shouldCreate = userItem != null && dishItem != null && !amountText.equals("");
        if (shouldCreate) {
            Order order = new Order(userItem.getId());
            orderService.createOrder(order);

            OrderEntry orderEntry = new OrderEntry(dishItem.getName(), order.getId(), dishItem.getPrice(), Parser.parseInteger(amountText));
            orderService.createOrderEntry(order.getId(), orderEntry);
        }
    }

    private void createDishCreator() {
        JLabel titleCreator = new JLabel("DISH CREATOR");
        titleCreator.setBounds(50, 725, 200, 15);

        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(10, 750, 200, 30);

        nameText = new JTextField("");
        nameText.setBounds(10, 775, 200, 20);

        JLabel priceLabel = new JLabel("Price: ");
        priceLabel.setBounds(10, 800, 200, 30);

        priceText = new JTextField("");
        priceText.setBounds(10, 825, 200, 20);

        JLabel maxOrdersLabel = new JLabel("Max Orders: ");
        maxOrdersLabel.setBounds(10, 850, 200, 30);

        maxOrdersText = new JTextField("");
        maxOrdersText.setBounds(10, 875, 200, 20);

        JLabel isVeganLabel = new JLabel("Is Vegan: ");
        isVeganLabel.setBounds(10, 900, 200, 30);

        radioButtonTrue = new JRadioButton("true");
        radioButtonFalse = new JRadioButton("false");

        radioButtonTrue.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                radioButtonFalse.setSelected(Boolean.FALSE);
            } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                radioButtonFalse.setSelected(Boolean.TRUE);
            }
        });

        radioButtonFalse.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.DESELECTED) {
                radioButtonTrue.setSelected(Boolean.TRUE);
            }
            if (e.getStateChange() == ItemEvent.SELECTED) {
                radioButtonTrue.setSelected(Boolean.FALSE);
            }
        });

        radioButtonTrue.setBounds(10, 925, 60, 20);
        radioButtonFalse.setBounds(80, 925, 60, 20);

        JButton save = new JButton("SAVE");
        save.setBounds(10, 950, 200, 15);

        save.addActionListener(e -> {
            createDish();
            updateDishesTable();
            updateComboBox();
            clearTextFields();
        });

        add(titleCreator);
        add(nameLabel);
        add(nameText);
        add(priceLabel);
        add(priceText);
        add(maxOrdersLabel);
        add(maxOrdersText);
        add(isVeganLabel);
        add(radioButtonFalse);
        add(radioButtonTrue);
        add(save);
    }

    private void createDish() {
        String name = nameText.getText();
        String price = priceText.getText();
        String maxOrders = maxOrdersText.getText();
        boolean isVegan = radioButtonTrue.isSelected();

        if (!name.equals("") && !price.equals("") && !maxOrders.equals("")) {
            Dish dish = new Dish(name, Parser.parseDouble(price), Parser.parseInteger(maxOrders), isVegan);
            dishService.createDish(dish);
        }
    }

    private void updateComboBox() {
        List<User> users = accountService.getUsers();
        userComboBox.removeAllItems();
        users.forEach(u -> userComboBox.addItem(u));

        List<Dish> dishes = dishService.getDishes();
        dishComboBox.removeAllItems();
        dishes.forEach(d -> dishComboBox.addItem(d));
    }

    private void clearTextFields() {
        amountText.setText("");
        loginText.setText("");
        passwordText.setText("");
        firstNameText.setText("");
        secondNameText.setText("");
        emailText.setText("");
        phoneText.setText("");
        cityText.setText("");
        streetText.setText("");
        houseText.setText("");
        postCodeText.setText("");

        nameText.setText("");
        priceText.setText("");
        maxOrdersText.setText("");
    }
}
