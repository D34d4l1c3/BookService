package itfbstudy.bookservice.controller;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.aop.CountedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import itfbstudy.exception.Response;
import itfbstudy.bookservice.service.BookService;
import itfbstudy.bookservice.enteties.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
@RestController
@RequestMapping("/books")
public class BookController {
    private BookService service;
    private CountedAspect countedAspect;
    private MeterRegistry registry;

    public BookController(BookService service, CountedAspect countedAspect, MeterRegistry registry) {
        this.registry = registry;
        this.countedAspect = countedAspect;
        this.service = service;
    }

//    @PostConstruct
//    public void init() {
//        counter = Counter
//                .builder("my.BananaCounter")
//                .description("counts something important")
//                .tag("environment", "test")
//                .tag("region", "us-east")
//                .register(registry);
//    }

    @GetMapping("")
    @Counted(value = "allBooksReqCount")
    public List<Book> findAllBooks() {
        return service.getBooks();
    }

    @PostMapping("/addBook")
    @Counted(value = "addBookReqCount")
    public Book addBook(@RequestBody Book book) {
        return service.saveBook(book);
    }
    @DeleteMapping("/{id}")
    @Counted(value = "deleteBookReqCount")
    public String deleteBook(@PathVariable int id) {
        return service.deleteBook(id);
    }
    @PostMapping("/updateBook/{id}")
    @Counted(value = "updateBookReqCount")
    public Book updateBook(@RequestBody Book book) {
        return service.updateBook(book);
    }

    @GetMapping("/{id}")
    @Counted(value = "getBookByIdReqCount")
    public Book findBookById(@PathVariable int id) {
        return service.getBookById(id);
    }

}

