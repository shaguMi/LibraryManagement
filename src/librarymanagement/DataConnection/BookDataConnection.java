/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagement.DataConnection;

import java.util.ArrayList;
import librarymanagement.Data.Book;

public class BookDataConnection extends DataConnection {
    
    public BookDataConnection(){
        tableName = "Books";
    }
    
    public ArrayList<Book> getAllBooks(){
        ArrayList<Book> result = new ArrayList<>();
        
        for(String[] book : selectAllRecords()){
            result.add(new Book(book[0],    //Id
                                book[1],    //ISBN
                                book[2],    //Title
                                book[3],    //Author
                                book[4]));  //Genre                   
        }
        
        return result;
    }
        
    public boolean updateData(Book book){
        String[] columnNames = Book.getColumnNames(true);
        String sqlStatement = String.format("UPDATE %s SET %s = '%s', %s = '%s', %s = '%s', %s = '%s' WHERE Id = '%s'",
                                    tableName,
                                        columnNames[1], book.isbn,
                                        columnNames[2], book.title,
                                        columnNames[3], book.author,
                                        columnNames[4], book.genre,
                                        book.id);
        
        return execute(sqlStatement);
    }
    
    public boolean insertData(Book book){
        String[] columnNames = Book.getColumnNames(true);
        String sqlStatement = String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES ('%s', '%s', '%s','%s')", 
                                      tableName,
                                          columnNames[1],columnNames[2],columnNames[3],columnNames[4],
                                          book.isbn, book.title, book.author, book.genre);
        
        return execute(sqlStatement);
    }
    
    public boolean deleteBook(Book book){
        return deleteRecord(book.id);
    }
    
    public ArrayList<Book> searchBooks(String text, String columnName){
        ArrayList<Book> bookResult = new ArrayList<>();

        String sqlStatement = String.format("SELECT * FROM %s WHERE %s LIKE '%%%s%%'", tableName, columnName, text);
        ArrayList<String[]> result = executeQuery(sqlStatement);
        
        for(String[] bookString : result){
            bookResult.add(new Book(bookString[0],    //Id
                                    bookString[1],    //ISBN
                                    bookString[2],    //Title
                                    bookString[3],    //Author
                                    bookString[4]));  //Genre                                       
        }
        
        return bookResult;
    }
}
