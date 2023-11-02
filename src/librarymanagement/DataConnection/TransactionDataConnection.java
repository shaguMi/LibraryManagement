/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagement.DataConnection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import librarymanagement.Data.TransactionItem;

public class TransactionDataConnection extends DataConnection {
    
    public static final String DateFormatString = "MM/dd/yyyy";
    
    public TransactionDataConnection(){
        tableName = "Transactions";
    }
    
    public ArrayList<TransactionItem> getAllTransactions(){
        ArrayList<TransactionItem> result = new ArrayList<>();
        
        for(String[] transaction : selectAllRecords()){
            result.add(new TransactionItem(transaction[0],                  //ID
                                transaction[1],                             //ISBN
                                transaction[2],                             //Nama Buku
                                transaction[3],                             //ID Anggota
                                transaction[4],                             //Nama Anggota                            
                                convertToDate(transaction[5]),     //Tanggal Pinjam
                                convertToDate(transaction[6]),    //Tanggal Kembali
                                transaction[7]));                           //Status
        }
        
        return result;
    }
    
    public static Date convertToDate(String dateString){
        SimpleDateFormat dateFormat = new SimpleDateFormat(DateFormatString); 
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return date;
    }  
    
    public boolean updateData(TransactionItem transactionItem){
        SimpleDateFormat sdf = new SimpleDateFormat(DateFormatString);
        
        String[] columnNames = TransactionItem.getColumnNames(true);
        String sqlStatement = String.format("UPDATE %s SET %s = '%s', %s = '%s', %s = '%s', %s = '%s', %s = '%s', %s = '%s', %s = '%s' WHERE Id = '%s'",
                                    tableName,
                                        columnNames[1], transactionItem.bookIsbn,
                                        columnNames[2], transactionItem.bookTitle,
                                        columnNames[3], transactionItem.userId,
                                        columnNames[4], transactionItem.userName,
                                        columnNames[5], sdf.format(transactionItem.checkInDate),
                                        columnNames[6], sdf.format(transactionItem.checkOutDate),
                                        columnNames[7], transactionItem.status,
                                        transactionItem.id);
        
        return execute(sqlStatement);
    }
    
    public boolean insertData(TransactionItem transactionItem){
        SimpleDateFormat sdf = new SimpleDateFormat(DateFormatString);
        
        String[] columnNames = TransactionItem.getColumnNames(true);
        String sqlStatement = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s) VALUES ('%s', '%s', '%s','%s','%s','%s','%s')", 
                            tableName,
                                columnNames[1],columnNames[2],columnNames[3],columnNames[4],columnNames[5],columnNames[6],columnNames[7],
                                transactionItem.bookIsbn,transactionItem.bookTitle, 
                                transactionItem.userId,transactionItem.userName,
                                sdf.format(transactionItem.checkInDate),sdf.format(transactionItem.checkOutDate),transactionItem.status);
        
        return execute(sqlStatement);
    }
    
}
