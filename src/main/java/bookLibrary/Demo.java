package bookLibrary;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Demo {

  static EntityManagerFactory emf;
  
  public static List<Author> getAuthorName(String name) {
    EntityManager em = emf.createEntityManager();    
    final TypedQuery<Author> query = em.createNamedQuery("findByAuthor", Author.class);
    query.setParameter("name", name);
    final List<Author> results = query.getResultList();
    em.close();
    return results;
  }

  public static List<Author> getNameFromID(String id) {
    EntityManager em = emf.createEntityManager();    
    final TypedQuery<Author> query = em.createNamedQuery("findByID", Author.class);
    query.setParameter("id", id);
    final List<Author> results = query.getResultList();
    em.close();
    return results;
  }

  public static void main(String[] args) {
    Author rowling = new Author("J.K. Rowling");
    Author herbert = new Author("Frank Herbert");
    emf = Persistence.createEntityManagerFactory("JPA");
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.merge(rowling);
    em.merge(herbert);
    em.getTransaction().commit();
    em.close();

    System.out.println("--Get Name Test---");

    System.out.println(getAuthorName("Frank Herbert"));

    System.out.println("---Get By ID Test---");

    System.out.println(getNameFromID("1"));

    emf.close();
  }

}
