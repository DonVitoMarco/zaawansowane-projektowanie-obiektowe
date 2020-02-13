package pl.marek.ui;

import pl.marek.model.User;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;

public class UserRendererComboBox extends BasicComboBoxRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value != null) {
            User item = (User) value;
            setText(item.getLogin());
        }

        if (index == -1) {
            User item = (User) value;
            assert item != null;
            setText("" + item.getLogin());
        }
        return this;
    }
}
