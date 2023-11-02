/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagement.Data;

public class Book {
    public String id;
    public String isbn;
    public String title;
    public String author;
    public String genre;
    
    public Book(){
    }
    
    public Book(String id, String isbn, String title, String author, String genre){
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }
    
    public static String[] getColumnNames(boolean isDbName){
        if (isDbName){
            String[] columns = { "Id", "ISBN", "Title", "Author", "Genre" };
            return columns;
        }
        else{
            String[] columns = { "Id", "ISBN", "Judul", "Penulis", "Genre" };
            return columns;
        }
    }   
}
