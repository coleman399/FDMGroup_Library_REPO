package bookLibrary;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Library")
public class Library {
	@Id
	@Column(name = "LIBRARY_ID")
	private int libraryId;
	@Column(name = "LIBRARY_NAME")
	private String libraryName;
	@Column(name = "LIBRARY_ADDRESS")
	private String libraryAddress;

	@OneToMany(cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<BookItem> books = new ArrayList<>();

	public Library() {
		super();
	}

	public Library(int libraryId, String libraryName, String libraryAddress) {
		super();
		this.libraryId = libraryId;
		this.libraryName = libraryName;
		this.libraryAddress = libraryAddress;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public String getLibraryAddress() {
		return libraryAddress;
	}

	public void setLibraryAddress(String libraryAddress) {
		this.libraryAddress = libraryAddress;
	}

	public void removeFromLibrary(BookItem book) {
		for (BookItem bookItem : books) {
			if (bookItem == book && bookItem.isBorrowed() == true) {
				books.remove(book);
			}
		}
	}

	@Override
	public String toString() {
		return "Library [libraryId=" + libraryId + ", libraryName=" + libraryName + ", libraryAddress=" + libraryAddress
				+ ", books=" + books + "]";
	}

	public List<BookItem> getBooks() {
		return books;
	}

	public void addBookItem(BookItem bookItem1) {
		books.add(bookItem1);

	}

}
