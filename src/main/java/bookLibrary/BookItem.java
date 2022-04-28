package bookLibrary;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class BookItem extends Book {

	@ManyToOne
	private Library library;

	public BookItem(String bookName, int iSBN, Date borrowedDate) {
		super(bookName, iSBN, borrowedDate);
	}

	public BookItem() {
	}

	@Override
	public void searchBook(String name) {

	}

	public void setLibrary(Library library) {
		this.library = library;

	}

}
