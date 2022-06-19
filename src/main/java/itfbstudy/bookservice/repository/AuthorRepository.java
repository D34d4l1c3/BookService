package itfbstudy.bookservice.repository;
import itfbstudy.bookservice.enteties.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
    Author findById(int id);
    void deleteById(int id);
}
