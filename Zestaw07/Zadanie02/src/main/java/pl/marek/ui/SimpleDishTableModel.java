package pl.marek.ui;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class SimpleDishTableModel extends AbstractTableModel {

    private String[] columnNames = {"Id", "Name", "Price", "MaxOrders", "Vegan"};
    private List<SimpleDish> data;

    public SimpleDishTableModel(List<SimpleDish> data) {
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
            temp = data.get(rowIndex).getName();
        } else if (columnIndex == 2) {
            temp = data.get(rowIndex).getPrice();
        } else if (columnIndex == 3) {
            temp = data.get(rowIndex).getMaxOrders();
        } else if (columnIndex == 4) {
            temp = data.get(rowIndex).getVegan();
        }
        return temp;
    }
}
