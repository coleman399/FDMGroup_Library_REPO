package bookLibrary;

import java.util.Date;

import javax.persistence.Entity;


@Entity
public class BookItem extends Book {

	public BookItem(String bookName, int iSBN, Date borrowedDate) {
		super(bookName, iSBN, borrowedDate);
	}

	public BookItem() {
	}

	@Override
	public void searchBook(String name) {

	}

}
