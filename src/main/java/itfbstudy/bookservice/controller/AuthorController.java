package itfbstudy.bookservice.controller;
import io.micrometer.core.instrument.MeterRegistry;
import itfbstudy.bookservice.advice.Response;
import itfbstudy.bookservice.enteties.Author;
import itfbstudy.bookservice.service.AuthorService;
import lombok.extern.log4j.Log4j;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

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
        System.out.println("POOOOOOST__author");
        return service.saveAuthor(author);
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
    public Author findAuthorById(@PathVariable int id) {
        System.out.println("authorById!!!!!!!! "+id);
        return service.getAuthorById(id);
    }

}