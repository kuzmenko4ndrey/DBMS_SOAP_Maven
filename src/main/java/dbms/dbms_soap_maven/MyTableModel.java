/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms.dbms_soap_maven;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Neophron
 */
public class MyTableModel extends AbstractTableModel{
    
    private String[] columnNames;
    private Object[][] data;
    
    public MyTableModel(Table t) {
        ArrayList<String> cn = t.getColNames();
        ArrayList<ArrayList<String>> d = t.getData();
        columnNames = new String[cn.size()];
        data = new Object[d.size()][cn.size()];
        for (int i = 0; i < columnNames.length; i++) {
            columnNames[i] = cn.get(i);
            for (int j = 0; j < d.size(); j++) {
                data[j][i] = d.get(j).get(i);
            }
        }
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    
    @Override
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
    
}
