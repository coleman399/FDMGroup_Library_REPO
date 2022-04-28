package bookLibrary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Demo {

	static EntityManagerFactory emf;

	public static List<Library> findAllBooksInLibrary() {
		final EntityManager em = emf.createEntityManager();
		final String jpql = "SELECT l FROM Library l";
		final TypedQuery<Library> query = em.createQuery(jpql, Library.class);
		final List<Library> results = query.getResultList();
		em.close();
		return results;
	}

	public static List<Author> getAuthorName(String name) {
		EntityManager em = emf.createEntityManager();
		final TypedQuery<Author> query = em.createNamedQuery("findByAuthor", Author.class);
		query.setParameter("name", name);
		final List<Author> results = query.getResultList();
		em.close();
		return results;
	}

	public static List<Book> findAllBooksForAuthor(Author author) {
		final EntityManager em = emf.createEntityManager();
		final String jpql = "SELECT b FROM Book b WHERE b.author LIKE :author";
		final TypedQuery<Book> query = em.createQuery(jpql, Book.class);
		query.setParameter("author", author);
		final List<Book> results = query.getResultList();
		em.close();
		return results;
	}

	public static List<Book> findByBookName(final String bookName) {
		// Optional<Book> foundBook = Optional.empty();
		final EntityManager em = emf.createEntityManager();
		final TypedQuery<Book> query = em.createNamedQuery("findByBookName", Book.class);
		query.setParameter("bookName", bookName);
		final List<Book> results = query.getResultList();
		// if (!results.isEmpty()) {
		// foundBook = Optional.of(results.get(0));
		// }
		em.close();
		return results;
	}

	public static List<Book> borrowedBookList(String patronName) {
		final EntityManager em = emf.createEntityManager();
		final TypedQuery<Book> query = em.createNamedQuery("borrowBookQuery", Book.class);
		query.setParameter("patronName", patronName);
		final List<Book> results = query.getResultList();
		em.close();
		return results;
	}

	public static void main(String[] args) throws ParseException {

		Author rowling = new Author("J.K. Rowling");
		Author herbert = new Author("Frank Herbert");

		emf = Persistence.createEntityManagerFactory("JPA");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(rowling);
		em.merge(herbert);
		em.getTransaction().commit();
		em.close();

		System.out.println(getAuthorName("Frank Herbert"));

		String sDate1 = "31/12/1998";
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

		BookItem bookItem1 = new BookItem("blah blah blah", 1234, date1);
		BookItem bookItem2 = new BookItem("blah blah blah", 1234, date1);

		em = emf.createEntityManager();

		em.getTransaction().begin();
		
		rowling.addBookItem(bookItem1);
		rowling.addBookItem(bookItem2);
		rowling = em.merge(rowling);
		bookItem1 = rowling.getBooks().get(0);
		bookItem1.setAuthor(rowling);
		bookItem2 = rowling.getBooks().get(1);
		bookItem2.setAuthor(rowling);
		em.getTransaction().commit();
		em.close();


    /****************************************************************************
     *                                                                           *
     * Create/save a Patron      																								 *
     * Borrow a book and save everything																				 *
     *                                                                           *
     ****************************************************************************/

		Patron patronOne = new Patron("Billy", "123 Main Street");
		Patron patronTwo = new Patron("Sarah", "456 East Sycamore");
		BookItem bookItemOne = new BookItem("blah blah blah", 1234, date1);
		BookItem bookItemTwo = new BookItem("bleh bleh bleh", 5678, date1);
		BookItem bookItemThree = new BookItem("grable grable grable", 0000, date1);
		BookItem bookItemFour = new BookItem("greble greble greble", 1111, date1);

		em = emf.createEntityManager();

		em.getTransaction().begin();

		bookItemOne = em.merge(bookItemOne);
		bookItemTwo = em.merge(bookItemTwo);
		bookItemThree = em.merge(bookItemThree);
		bookItemFour = em.merge(bookItemFour);
		patronOne.borrowBook(bookItemOne);
		patronOne.borrowBook(bookItemTwo);
		patronTwo.borrowBook(bookItemThree);
		patronTwo.borrowBook(bookItemFour);
		patronOne = em.merge(patronOne);
		patronTwo = em.merge(patronTwo);

		em.getTransaction().commit();

		em.close();

		em = emf.createEntityManager();

		final List<Book> results = findAllBooksForAuthor(rowling);
		System.out.println(results);

		final List<Book> searchByBookResults = findByBookName("blah blah blah");
		System.out.println(searchByBookResults);
		em.close();
    
    final List<Book> borrowedBookList = borrowedBookList("Sarah");
		System.out.println(borrowedBookList);
		em.close();

		// ----Library-----

    Library library = new Library(1, "USA Library", "USA-1");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		library.addBookItem(bookItem1);
		library.addBookItem(bookItem2);
		em.merge(library);
		bookItem1 = library.getBooks().get(0);
		bookItem1.setLibrary(library);
		em.getTransaction().commit();
		em.close();
		System.out.println("-----Library------");
		System.out.println(findAllBooksInLibrary());

		emf.close();
	}

}
