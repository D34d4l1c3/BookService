package itfbstudy.bookservice.advice;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log4j2
public class DefaultAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleException(Exception e) {
        Response response = new Response(e.getMessage());
        log.error("Anna banana "+e.getMessage());
        System.out.println("MY_COMMON_ERROR_HANDLE_BITCH: "+e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}