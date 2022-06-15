package itfbstudy.bookservice.service;

import itfbstudy.bookservice.enteties.Book;
import itfbstudy.bookservice.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookService {
    private final BooksRepository repository;
    public BookService(BooksRepository repository) {
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
        return Optional.of(repository.findById(id)).orElse(null);
//        return Optional.of(repository.findById(id)).orElseThrow(() -> new NullPointerException ("vjqdfdas"));
    }

    public List<Book> getBookByName(String name) {
        return repository.findByName(name);
    }

    public String deleteBook(int id) {
        repository.deleteById(id);
        return "Book deleted: " + id;
    }

    public Book updateBook(Book Book) {
        Book existingBook = Optional.of(repository.findById(Book.getId())).orElse(null);
        existingBook.setName(Book.getName());
        existingBook.setGenre(Book.getGenre());
        existingBook.setReview(Book.getGenre());
        existingBook.setAuthors(Book.getAuthors());
        return repository.save(existingBook);
    }
}
