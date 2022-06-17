package itfbstudy.bookservice.advice;

import lombok.Getter;
public class AuthorNotFound extends RuntimeException {
    @Getter
    private String type = "AuthorNotFound";
}