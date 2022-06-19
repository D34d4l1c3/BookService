//package itfbstudy.exception;
//
//import itfbstudy.bookservice.exception.AuthorNotFound;
//import itfbstudy.bookservice.exception.BookNotFound;
//import itfbstudy.transactionservise.exception.TransactionError;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//@Log4j2
//public class DefaultAdvice {
//    private  Response response;
//
////    @ExceptionHandler(Exception.class)
////    public ResponseEntity<Response> handleException(Exception e) {
////        log.error(e.getMessage());
////        response.setMessage(e.getMessage());
////        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
////    }
////    @ExceptionHandler(AuthorNotFound.class)
////    public ResponseEntity<Response> handleException(AuthorNotFound e) {
////        response.setMessage(e.getType());
////        log.error(response.getMessage());
////        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
////    }
////    @ExceptionHandler(BookNotFound.class)
////    public ResponseEntity<Response> handleException(BookNotFound e) {
////        response.setMessage(e.getType());
////        log.error(response.getMessage());
////        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
////    }
////    @ExceptionHandler({TransactionError.class,BookNotFound.class,AuthorNotFound.class})
////    public ResponseEntity<Response> handleException(Response e) throws Response {
////        log.error(response.getMessage()+" "+e.getCode());
////        throw response;
////    }
//}