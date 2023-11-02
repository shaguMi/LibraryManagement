/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagement.DataConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public abstract class DataConnection {

    final protected String dbUrl = "jdbc:sqlite:db\\LibraryDb.db";   
    protected String tableName = "";
   
    protected boolean execute(String sqlStatement){
        Connection connect;
        Statement statement;
                
        try
        {
            connect = DriverManager.getConnection(dbUrl);
            statement = connect.createStatement();
            
            statement.execute(sqlStatement);
            
            statement.close();
            connect.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        
        return true;
    }
    
    protected ArrayList<String[]> executeQuery(String sqlStatement){
        ArrayList<String[]> result = new ArrayList<>();
        
        Connection connect;
        Statement statement;
        
        try
        {
            connect = DriverManager.getConnection(dbUrl);
            statement = connect.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();           
            
            while(resultSet.next()){
                String[] resultString = new String[(resultSetMetaData.getColumnCount())];
                
                for (int i = 0; i < resultString.length; i++) {
                    resultString[i] = resultSet.getString(i+1);
                }
                
                result.add(resultString);
            }
            
            statement.close();
            connect.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        return result;
    }            
    
    protected ArrayList<String[]> selectAllRecords(){
        String sqlStatement = String.format("SELECT * FROM %s", tableName);
        return executeQuery(sqlStatement);
    }            
    
    protected boolean deleteRecord(String id){
        String sqlStatement = String.format("DELETE FROM %s WHERE Id = '%s'", tableName, id);
        return execute(sqlStatement);
    }
}
