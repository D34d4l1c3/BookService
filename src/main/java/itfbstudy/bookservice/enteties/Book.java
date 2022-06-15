package itfbstudy.bookservice.enteties;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "BOOK")
@Transactional
public class Book {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "REVIEW")
    private String review;

    @Column(name = "GENRE")
    private String genre;

    //@JsonBackReference
    //@JsonManagedReference
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @ManyToMany(mappedBy = "books",fetch = FetchType.EAGER)
    private List<Author> authors = new ArrayList<Author>();

    @Transactional
    public void addAuthors(Author author){
        this.authors.add(author);
        author.getBooks().add(this);
    }

    public String getName() {
        return name;
    }

}
