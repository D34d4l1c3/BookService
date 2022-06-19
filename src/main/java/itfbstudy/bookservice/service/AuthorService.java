package itfbstudy.bookservice.service;
import itfbstudy.bookservice.exception.AuthorNotFound;
import itfbstudy.bookservice.enteties.Author;
import itfbstudy.bookservice.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AuthorService {
    private final AuthorRepository repository;
    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }
    public Author saveAuthor(Author Author) {
        return repository.save(Author);
    }

    public List<Author> saveAuthors(Set<Author> Authors) {
        return repository.saveAll(Authors);
    }

    public List<Author> getAuthors() {
        return repository.findAll();
    }
    public Author getAuthorById(int id) {
        Author author = repository.findById(id);
        if (author == null) throw new AuthorNotFound();
        return author;
    }

    public List<Author> getAuthorByName(String fullname) {
        return repository.findByFullName(fullname);
    }

    public String deleteAuthor(int id) {
        repository.deleteById(id);
        return "Author deleted: " + id;
    }

    public Author updateAuthor(Author Author) {
        Author existingAuthor = Optional.of(repository.findById(Author.getId())).orElse(null);
        existingAuthor.setFullName(Author.getFullName());
        existingAuthor.setBooks(Author.getBooks());
        return repository.save(existingAuthor);
    }
}

