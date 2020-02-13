package pl.marek.ui;

import pl.marek.model.Dish;
import pl.marek.service.IDishService;
import pl.marek.util.Parser;

import javax.swing.*;
import java.awt.event.ItemEvent;

public class UpdateDishFrame extends JFrame {

    private String id;
    private IDishService dishService;
    private Dish dish;

    protected JTextField nameText;
    protected JTextField priceText;
    protected JTextField maxOrdersText;
    protected JRadioButton radioButtonTrue;
    protected JRadioButton radioButtonFalse;

    public UpdateDishFrame(String id, IDishService dishService) {
        this.id = id;
        this.dishService = dishService;
        this.dish = dishService.getDish(id);

        setVisible(true);
        setLayout(null);
        setResizable(false);
        setTitle("ZZPO");
        setSize(350, 350);

        createForm();
        setValues();
    }

    public void createForm() {
        JLabel titleCreator = new JLabel("DISH UPDATE");
        titleCreator.setBounds(50, 25, 200, 15);

        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(10, 50, 200, 30);

        nameText = new JTextField("");
        nameText.setBounds(10, 75, 200, 20);

        JLabel priceLabel = new JLabel("Price: ");
        priceLabel.setBounds(10, 100, 200, 30);

        priceText = new JTextField("");
        priceText.setBounds(10, 125, 200, 20);

        JLabel maxOrdersLabel = new JLabel("Max Orders: ");
        maxOrdersLabel.setBounds(10, 150, 200, 30);

        maxOrdersText = new JTextField("");
        maxOrdersText.setBounds(10, 175, 200, 20);

        JLabel isVeganLabel = new JLabel("Is Vegan: ");
        isVeganLabel.setBounds(10, 200, 200, 30);

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

        radioButtonTrue.setBounds(10, 225, 60, 20);
        radioButtonFalse.setBounds(80, 225, 60, 20);

        JButton update = new JButton("UPDATE");
        update.setBounds(10, 250, 200, 15);

        update.addActionListener(e -> {
            updateDish();
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
        add(update);
    }

    public void setValues() {
        nameText.setText(dish.getName());
        priceText.setText(Double.toString(dish.getPrice()));
        maxOrdersText.setText(Integer.toString(dish.getMaxOrders()));

        if (dish.isVegan()) {
            radioButtonTrue.setSelected(Boolean.TRUE);
        } else {
            radioButtonFalse.setSelected(Boolean.TRUE);
        }
    }

    public void updateDish() {
        String name = nameText.getText();
        String price = priceText.getText();
        String maxOrders = maxOrdersText.getText();
        boolean isVegan = radioButtonTrue.isSelected();

        if (!name.equals("") && !price.equals("") && !maxOrders.equals("")) {
            Dish updateDish = new Dish(id, name, Parser.parseDouble(price), Parser.parseInteger(maxOrders), isVegan);
            dishService.updateDish(updateDish);
        }
    }
}
