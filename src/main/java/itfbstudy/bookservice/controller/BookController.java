package itfbstudy.bookservice.controller;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.aop.CountedAspect;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import itfbstudy.bookservice.advice.Response;
import itfbstudy.bookservice.service.BookService;
import itfbstudy.bookservice.enteties.Book;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
@RestController
@RequestMapping("/books")
public class BookController {
    //  Аннотация Autowired здесь означает, что когда Spring находит аннотацию @Autowired,
    //  он автоматически найдет Bean, который соответствует ей в контексте кода
    //  (по умолчанию - соответствие типа), и автоматически вставит его в соответствующее место.
    // @Autowired
    private BookService service;
    private CountedAspect countedAspect;
//    private Counter counter;
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
        System.out.println("POOOOOOST");
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
        System.out.println("test");
        return service.updateBook(book);
    }

    @GetMapping(value = "/error", produces = APPLICATION_JSON_VALUE)
    public Response testDefaultControllerAdvice(@RequestParam(required = false, defaultValue = "false") boolean exception)
            throws Exception {
        if (exception) {
            throw new Exception("MyException in testDefaultControllerAdvice");
        }
        return new Response("OK");
    }
    @GetMapping("/{id}")
    @Counted(value = "getBookByIdReqCount")
    public Book findBookById(@PathVariable int id) {
        return service.getBookById(id);
    }

}

