package main.java.com.fdmgroup;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void returnBook(ArrayList<Book> books) {

    }

    public void borrowBook(Book book) {

    }

    public boolean searchBook(String bookName) {
        return true;
    }

    // don't know if we need
    // public boolean borrowedBook(Book book) {
    // return true;
    // }
}
