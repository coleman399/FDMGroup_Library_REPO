package bookLibrary;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQuery(name = "borrowBookQuery", query = "SELECT p.borrowedBooks FROM Patron p WHERE p.patronName LIKE :patronName")

@Entity
@Table(name = "Patron")
public class Patron {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "PATRON_NAME")
	private String patronName;

	@Column(name = "PATRON_ADDRESS")
	private String patronAddress;

	@OneToMany (cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "FK_BOOK_NO")
	private List<BookItem> borrowedBooks = new ArrayList<>();

	public Patron(String patronName, String patronAddress) {
		this.patronName = patronName;
		this.patronAddress = patronAddress;
	}

	public Patron() {
	}

	public String getPatronName() {
		return patronName;
	}

	public void setPatronName(String patronName) {
		this.patronName = patronName;
	}

	public String getPatronAddress() {
		return patronAddress;
	}

	public void setPatronAddress(String patronAddress) {
		this.patronAddress = patronAddress;
	}

	public void borrowBook(BookItem book) {
		borrowedBooks.add(book);
	}

	public List<BookItem> getBooks() {
		return this.borrowedBooks;
	}

	@Override
  public String toString() {
    return "Patron [borrowedBooks=" + borrowedBooks + ", id=" + id + ", patronAddress=" + patronAddress
        + ", patronName=" + patronName + "]";
  }
}
