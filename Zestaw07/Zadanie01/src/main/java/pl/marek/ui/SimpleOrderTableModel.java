package pl.marek.ui;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class SimpleOrderTableModel extends AbstractTableModel {

    private String[] columnNames = {"Id", "DishName", "Price", "Amount", "TotalCost", "Username"};
    private List<SimpleOrder> data;

    public SimpleOrderTableModel(List<SimpleOrder> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        int size;
        if (data == null) {
            size = 0;
        } else {
            size = data.size();
        }
        return size;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }


    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Class getColumnClass(int col) {
        return String.class;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;
        if (columnIndex == 0) {
            temp = data.get(rowIndex).getId();
        } else if (columnIndex == 1) {
            temp = data.get(rowIndex).getDishName();
        } else if (columnIndex == 2) {
            temp = data.get(rowIndex).getPrice();
        } else if (columnIndex == 3) {
            temp = data.get(rowIndex).getAmount();
        } else if (columnIndex == 4) {
            temp = data.get(rowIndex).getTotalCost();
        } else if (columnIndex == 5) {
            temp = data.get(rowIndex).getUsername();
        }
        return temp;
    }
}
