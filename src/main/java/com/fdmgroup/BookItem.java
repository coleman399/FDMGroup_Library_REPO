package com.fdmgroup;

import java.util.Date;

public class BookItem extends Book {

	private int barCode;
	private Date borrowedDate;

	public BookItem(int bOOKID, String bookName, int iSBN, String bookPublisherName, int barCode, Date borrowedDate) {
		super(bOOKID, bookName, iSBN, bookPublisherName);
		this.barCode = barCode;
		this.borrowedDate = borrowedDate;
	}

	public int getBarCode() {
		return barCode;
	}

	public void setBarCode(int barCode) {
		this.barCode = barCode;
	}

	public Date getBorrowedDate() {
		return borrowedDate;
	}

	public void setBorrowedDate(Date borrowedDate) {
		this.borrowedDate = borrowedDate;
	}

	@Override
	public String toString() {
		return "BookItem [barCode=" + barCode + ", borrowedDate=" + borrowedDate + "]";
	}

}
