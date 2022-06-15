package itfbstudy.bookservice.repository;

import itfbstudy.bookservice.enteties.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

//TODO Передлать на Set?
@Repository
public interface BooksRepository extends JpaRepository<Book,Integer> {
    Book findById(int id);
    List<Book> findByName(String name);
    void deleteById(int id);
}
