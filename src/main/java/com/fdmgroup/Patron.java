package com.fdmgroup;

import java.util.ArrayList;

public class Patron extends Library {

	public Patron(ArrayList<Book> books) {
		super(books);
	}

	@Override
	public boolean searchBook(String bookName) {

		return true;
	}

	@Override
	public void borrowBook(Book book) {

	}

	@Override
	public void returnBook(ArrayList<Book> books) {

	}

}
