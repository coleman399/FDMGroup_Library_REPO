package bookLibrary;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Book")
public abstract class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BOOK_ID")
	private int BOOKID;
	@Column(name = "BOOK_NAME")
	private String bookName;
	@Column(name = "BOOK_ISBN")
	private int ISBN;

	@Column(name = "BOOK_BORROWED_DATE")
	private Date borrowedDate;

	@ManyToOne
	private Author author;

	public Book() {

	}

	public Book(String bookName, int iSBN, Date borrowedDate) {
		this.bookName = bookName;
		ISBN = iSBN;
		this.borrowedDate = borrowedDate;
	}

	public Date getBorrowedDate() {
		return borrowedDate;
	}

	public void setBorrowedDate(Date borrowedDate) {
		this.borrowedDate = borrowedDate;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public int getBOOKID() {
		return BOOKID;
	}

	@Override
	public String toString() {
		return "Book [BOOKID=" + BOOKID + ", bookName=" + bookName + ", ISBN=" + ISBN + "]";
	}

	public void searchBook(String name) {

	}

}
