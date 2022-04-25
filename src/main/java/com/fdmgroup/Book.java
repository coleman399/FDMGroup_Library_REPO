package com.fdmgroup;

public class Book {
    private final int BOOKID;
    private String title;
    private String author;

    public Book(int bOOKID, String title, String author) {
        BOOKID = bOOKID;
        this.title = title;
        this.author = author;
    }

    public int getBOOKID() {
        return BOOKID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
