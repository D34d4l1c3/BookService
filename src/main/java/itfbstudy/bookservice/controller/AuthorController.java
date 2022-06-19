package itfbstudy.bookservice.controller;
import itfbstudy.exception.Response;
import itfbstudy.bookservice.enteties.Author;
import itfbstudy.bookservice.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    //  Аннотация @Autowired здесь означает, что когда Spring находит аннотацию @Autowired,
    //  он автоматически найдет Bean, который соответствует ей в контексте кода
    //  (по умолчанию - соответствие типа), и автоматически вставит его в соответствующее место.
    private AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @PostMapping("/addAuthor")
    public Author addAuthor(@RequestBody Author author) {
        return service.saveAuthor(author);
    }
//    @GetMapping(value = "/error", produces = APPLICATION_JSON_VALUE)
//    public Response testDefaultControllerAdvice(@RequestParam(required = false, defaultValue = "false") boolean exception)
//            throws Exception {
//        if (exception) {
//            throw new Exception("MyException in testDefaultControllerAdvice");
//        }
//        return new Response("OK");
//    }

    @GetMapping("/{id}")
    public Author findAuthorById(@PathVariable int id){
        System.out.println("authorById!!!!!!!! "+id);
        return service.getAuthorById(id);
    }

}