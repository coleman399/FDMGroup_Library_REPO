package bookLibrary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name = "findByAuthor", query = "SELECT a FROM Author a WHERE a.authorName = :name")

@Entity
@Table(name="Author")
public class Author {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="AUTHOR_NAME")
    private String authorName;

    public Author(final String authorName) {
        this.authorName = authorName;
    }

    public Author() {
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(final String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
      return "Author [authorName=" + authorName + ", id=" + id + "]";
    }

    

    
    
}
