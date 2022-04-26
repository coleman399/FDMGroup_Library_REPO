package bookLibrary;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Demo {

  static EntityManagerFactory emf;

  public static List<String> getAuthorName() {
    EntityManager em = emf.createEntityManager();

    final String jpql = "SELECT a.authorName FROM Author a";
    final TypedQuery<String> query = em.createQuery(jpql, String.class);
    final List<String> results = query.getResultList();
    em.close();
    return results;
  }

  public static void main(String[] args) {
    Author rowling = new Author("J.K. Rowling");
    Author herbert = new Author("Frank Herbert");
    emf = Persistence.createEntityManagerFactory("JPA");
    EntityManager em = emf.createEntityManager();
    EntityTransaction t = em.getTransaction();
    t.begin();
    rowling = em.merge(rowling);
    herbert = em.merge(herbert);
    em.getTransaction().commit();
    em.close();
    System.out.println(getAuthorName().toString());
    emf.close();
  }

}
