/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.TableModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import librarymanagement.Data.User;

public class UserTableModel extends AbstractTableModel {
    ArrayList<User> users;
    String[] columns;
    
    public UserTableModel(ArrayList<User> users){
        this.users = users;
        this.columns = User.getColumnNames(false);
    }
    
    @Override
    public int getRowCount() {
        return users.size();
    }
    
    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int col){
        return columns[col];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        User user = users.get(rowIndex);
        String result = null;
        
        switch (columnIndex) {
            case 0:
                result = user.id;
                break;
            case 1:
                result = user.name;
                break;
            case 2:
                result = user.address;
                break;
            case 3:
                result = user.phone;
                break;
            case 4:
                result = user.status;
                break;
            default:
                break;
        }
        
        return result;
    }
}
