package itfbstudy.bookservice.service;

import itfbstudy.bookservice.exception.BookNotFound;
import itfbstudy.bookservice.enteties.Author;
import itfbstudy.bookservice.enteties.Book;
import itfbstudy.bookservice.repository.AuthorRepository;
import itfbstudy.bookservice.repository.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookService {
    private final BooksRepository repository;
    private final AuthorRepository repoAuthor;
    public BookService(BooksRepository repository, AuthorRepository repoAuthor) {
        this.repoAuthor = repoAuthor;
        this.repository = repository;
    }
    public Book saveBook(Book Book) {
        return repository.save(Book);
    }

    public List<Book> saveBooks(Set<Book> Books) {
        return repository.saveAll(Books);
    }

    public List<Book> getBooks() {
        return repository.findAll();
    }
    public Book getBookById(int id) {
        Book book = repository.findById(id);
        if(book == null) throw new BookNotFound();
        return book;
    }

    public String deleteBook(int id) {
        repository.deleteById(id);
        return "Book deleted: " + id;
    }

    public Book updateBook(Book Book) {
        System.out.println("Service updateBook");
        Book existingBook = Optional.of(repository.findById(Book.getId())).orElseThrow(BookNotFound::new);
        existingBook.setName(Book.getName() == null ? existingBook.getName() : Book.getName());
        existingBook.setGenre(Book.getGenre() == null ? existingBook.getGenre() : Book.getGenre());
        existingBook.setReview(Book.getReview() == null ? existingBook.getReview() : Book.getReview());
        List<Author> authors= Book.getAuthors();

        if (Book.getAuthors() == null) {
            System.out.println("нету авторов?");
        } else {
            Author existAuthor;
            for (Author el: authors) {
                System.out.println(el);
                existAuthor = repoAuthor.findById(el.getId());
                if(existAuthor != null) {
                    existingBook.addAuthors(existAuthor);
                } else if(el.getFullName() != null && !el.getFullName().equals("")){
                    Author author = new Author(el.getFullName());
                    existingBook.addAuthors(author);
                    repoAuthor.save(author);
                }
            }
        }
        return repository.save(existingBook);
    }
}
