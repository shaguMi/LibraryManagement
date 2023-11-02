/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagement.DataConnection;

import java.util.ArrayList;
import librarymanagement.Data.User;

public class UserDataConnection extends DataConnection {
    
    public UserDataConnection(){
        tableName = "Users";
    }
    
    public ArrayList<User> getAllUsers(){
        ArrayList<User> result = new ArrayList<>();
        
        for(String[] user : selectAllRecords()){
            result.add(new User(user[0],    //ID
                                user[1],    //Name
                                user[2],    //Address
                                user[3],    //Phone
                                user[4]));  //Status
        }
        
        return result;
    }
    
    public boolean updateData(User user){
        String[] columnNames = User.getColumnNames(true);
        String sqlStatement = String.format("UPDATE %s SET %s = '%s', %s = '%s', %s = '%s', %s = '%s' WHERE Id = '%s'",
                            tableName,
                                columnNames[1], user.name,
                                columnNames[2], user.address,
                                columnNames[3], user.phone,
                                columnNames[4], user.status,
                                user.id);
        
        return execute(sqlStatement);
    }
    
    public boolean insertData(User user){
        String[] columnNames = User.getColumnNames(true);
        String sqlStatement = String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES ('%s', '%s', '%s','%s')", 
                            tableName,
                                columnNames[1],columnNames[2],columnNames[3],columnNames[4],
                                user.name, user.address,user.phone,user.status);
        
        return execute(sqlStatement);
    }
    
    public boolean deleteUser(User user){
        return deleteRecord(user.id);
    }
}
