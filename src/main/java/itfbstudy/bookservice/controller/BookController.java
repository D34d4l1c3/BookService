package itfbstudy.bookservice.controller;

import itfbstudy.bookservice.advice.Response;
import itfbstudy.bookservice.service.BookService;
import itfbstudy.bookservice.enteties.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/books")
public class BookController {

    //  Аннотация @Autowired здесь означает, что когда Spring находит аннотацию @Autowired,
    //  он автоматически найдет Bean, который соответствует ей в контексте кода
    //  (по умолчанию - соответствие типа), и автоматически вставит его в соответствующее место.
//    @Autowired
    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }
    @GetMapping("")
    public List<Book> findAllBooks() {
        System.out.println("GET_ALLLLL");
        return new ArrayList<Book>();
    }

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book) {
        System.out.println("POOOOOOST");
        return service.saveBook(book);
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
    public Book findBookById(@PathVariable int id) {
        System.out.println("bookById!!!!!!!! "+id);
        // service.getBookById(Integer.getInteger(id));
        return service.getBookById(id);
        // return id +" Annababa";
    }

}

