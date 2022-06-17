package itfbstudy.bookservice.advice;

import lombok.Getter;
public class BookNotFound extends RuntimeException {
    @Getter
    private String type = "BookNotFound";
}