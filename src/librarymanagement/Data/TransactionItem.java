/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagement.Data;

import java.util.Date;

public class TransactionItem {
    public String id;
    public String bookIsbn;
    public String bookTitle;
    public String userId;
    public String userName;
    public Date checkInDate;
    public Date checkOutDate;
    public String status;
    
    public TransactionItem (){
    }
    
    public TransactionItem(String id,String bookIsbn,String bookTitle, String userId, String userName,Date checkInDate,Date checkOutDate, String status){
        this.id = id;
        this.bookIsbn = bookIsbn;
        this.bookTitle = bookTitle;
        this.userId = userId;
        this.userName = userName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
    }
    
    public static String[] getColumnNames(boolean isDbName){
        if (isDbName){
            String[] columns = { "Id", "ISBN", "BookName", "UserId", "UserName", "CheckInDate","CheckOutDate","Status" };
            return columns;
        }
        else{
            String[] columns = { "Id Pinjam", "ISBN","Nama Buku", "ID Anggota", "Nama Anggota", "Tanggal Pinjam", "Tanggal Kembali","Status" };
            return columns;
        }
    }
}
