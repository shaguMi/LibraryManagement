/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagement.Data;

public class User {
    public String id;
    public String name;
    public String address;
    public String phone;
    public String status;
    
    public User(){
    }
    
    public User(String id,String name,String address, String phone, String status){
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.status = status;
    }
   
    public static String[] getColumnNames(boolean isDbName){
        if (isDbName){
            String[] columns = { "Id", "Name", "Address", "Phone", "Status"};
            return columns;
        }
        else{
            String[] columns = { "ID Anggota", "Nama", "Alamat", "Nomor Telepon", "Status" };
            return columns;
        }
    }  
}
