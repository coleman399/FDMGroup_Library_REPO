package com.fdmgroup;

public abstract class Book {
	private final int BOOKID;
	private String bookName;
	private int ISBN;
	private String bookPublisherName;

	public Book(int bOOKID, String bookName, int iSBN, String bookPublisherName) {
		super();
		BOOKID = bOOKID;
		this.bookName = bookName;
		ISBN = iSBN;
		this.bookPublisherName = bookPublisherName;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getBookPublisherName() {
		return bookPublisherName;
	}

	public void setBookPublisherName(String bookPublisherName) {
		this.bookPublisherName = bookPublisherName;
	}

	public int getBOOKID() {
		return BOOKID;
	}

	@Override
	public String toString() {
		return "Book [BOOKID=" + BOOKID + ", bookName=" + bookName + ", ISBN=" + ISBN + ", bookPublisherName="
				+ bookPublisherName + "]";
	}

}
