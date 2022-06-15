package itfbstudy.bookservice.enteties;

import com.fasterxml.jackson.annotation.*;
import itfbstudy.bookservice.repository.AuthorRepository;
import itfbstudy.bookservice.repository.BooksRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name = "AUTHOR")
@Getter
@Setter
public class Author {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "FULL_NAME")
    private String fullName;

    //@JsonIgnore
    //@JsonBackReference
    //@JsonManagedReference
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @ManyToMany //Не смогла сделать работу в отдельной сессии, а иначе LAZY до-подгружать связанные объекты из интерсекшена гемор
    private List<Book> books = new ArrayList<Book>();

    public Author(String fullName){
        this.fullName = fullName;
    }
    public Author(int id,String fullName,List<Book> books){
        this.id = id;
        this.fullName = fullName;
        this.books = books;
    }

    public Author addBook(Book book){
        this.books.add(book);
        book.addAuthors(this);
        return this;
    }
    public List<Book> getBooks() {
        return books;
    }
}
