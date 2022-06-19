package itfbstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args)  {
        SpringApplication.run(Application.class, args);

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
