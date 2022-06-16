package itfbstudy.bookservice;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//@Configuration
@SpringBootApplication
public class BookServiceApplication{

    public static void main(String[] args)  {
        SpringApplication.run(BookServiceApplication.class, args);

//        BooksRepository bookRepository = context.getBean(BooksRepository.class);
//        AuthorRepository authorRepository = context.getBean(AuthorRepository.class);
////        Set<Book> bookList = bookRepository.findByName("Test3");
////        Author author1 = new Author("Рыжкова Марина");
//        Author author = authorRepository.findById(14);
//        Book book = new Book("Кто прячется в тени","фентещи","Про вампров");
//        book.addAuthors(author);



        //author.addBook(book);
        //bookRepository.save(book);
        //authorRepository.save(author);
    }

}
