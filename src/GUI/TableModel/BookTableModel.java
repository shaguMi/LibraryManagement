/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.TableModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import librarymanagement.Data.Book;

public class BookTableModel extends AbstractTableModel{

    ArrayList<Book> books;
    String[] columns;
    
    public BookTableModel(ArrayList<Book> books){
        this.books = books;
        this.columns = Book.getColumnNames(false);
    }
    
    @Override
    public int getRowCount() {
        return books.size();
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
        Book book = books.get(rowIndex);
        String result = null;
        
        switch (columnIndex) {
            case 0:
                result = book.id;
                break;
            case 1:
                result = book.isbn;
                break;
            case 2:
                result = book.title;
                break;
            case 3:
                result = book.author;
                break;
            case 4:
                result = book.genre;
                break;
            default:
                break;
        }
        
        return result;
    } 
}
