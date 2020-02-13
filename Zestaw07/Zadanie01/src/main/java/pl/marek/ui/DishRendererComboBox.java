package pl.marek.ui;

import pl.marek.model.Dish;
import pl.marek.model.User;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;

public class DishRendererComboBox extends BasicComboBoxRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value != null) {
            Dish item = (Dish) value;
            setText(item.getName());
        }

        if (index == -1) {
            Dish item = (Dish) value;
            assert item != null;
            setText("" + item.getName());
        }
        return this;
    }
}
