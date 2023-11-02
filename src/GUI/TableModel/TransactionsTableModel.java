/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.TableModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import librarymanagement.Data.TransactionItem;
import librarymanagement.DataConnection.TransactionDataConnection;

public class TransactionsTableModel extends AbstractTableModel {
    ArrayList<TransactionItem> transactions;
    String[] columns;
    
    public TransactionsTableModel(ArrayList<TransactionItem> transactions){
        this.transactions = transactions;
        this.columns = TransactionItem.getColumnNames(false);
    }
    
    @Override
    public int getRowCount() {
        return transactions.size();
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
        TransactionItem transaction = transactions.get(rowIndex);
        String result = null;
        SimpleDateFormat sdf = new SimpleDateFormat(TransactionDataConnection.DateFormatString);
        
        switch (columnIndex) {
            case 0:
                result = transaction.id;
                break;
            case 1:
                result = transaction.bookIsbn;
                break;
            case 2:
                result = transaction.bookTitle;
                break;
            case 3:
                result = transaction.userId;
                break;
            case 4:
                result = transaction.userName;
                break;
            case 5:
                result = sdf.format(transaction.checkInDate);
                break;
            case 6:
                result = sdf.format(transaction.checkOutDate);
                break;
            case 7:
                result = transaction.status;  
                break;
            default:
                break;
        }
        
        return result;
    }
}
