package itfbstudy.bookservice.exception;

import itfbstudy.exception.IResponse;
import lombok.Getter;
public class AuthorNotFound extends RuntimeException implements IResponse {
    private String message = "Такого автора не существует";
    private int code = 404;

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}