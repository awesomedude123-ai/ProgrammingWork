package edu.psu.ist.model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class UserTableModel extends AbstractTableModel {

    private String[] columnNames = {"Name", "Type"};

    private List<User> users;

    public UserTableModel(){
        this.users = new ArrayList<User>();
    }

    public User getUser(int rowIndex){
        return this.users.get(rowIndex);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public int getRowCount() {
        return this.users.size();
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                return this.users.get(rowIndex).getName();
            }
            case 1 -> {
                return this.users.get(rowIndex).getType();
            }
        }//end switch case statement

        return null;
    }
}
