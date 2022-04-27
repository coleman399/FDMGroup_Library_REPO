package bookLibrary;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
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
